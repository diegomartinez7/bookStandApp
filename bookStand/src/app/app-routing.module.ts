import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorsComponent } from './components/authors/authors.component';
import { BookComponent } from './components/book/book.component';
import { CatalogueComponent } from './components/catalogue/catalogue.component';
import { EditorialsComponent } from './components/editorials/editorials.component';
import { LoginComponent } from './components/login/login.component';
import { MainComponent } from './components/main/main.component';
import { RegisterComponent } from './components/register/register.component';
import { AuthGuard } from './helpers/auth.guard';

const routes: Routes = [
  { path: 'register', component: RegisterComponent, canActivate: [AuthGuard], data: { sessionRequired: false } },
  { path: 'login', component: LoginComponent, canActivate: [AuthGuard], data: { sessionRequired: false } },
  { 
    path: '',
    component: MainComponent,
    //aquí va el canActivate
    canActivate: [AuthGuard],
    data: { sessionRequired: true },
    children: [
      { path: 'catalogue', component: CatalogueComponent },
      { path: 'authors', component: AuthorsComponent },
      { path: 'editorials', component: EditorialsComponent },
      { path: 'books', component: BookComponent }
    ]
  },
  { path: '**', redirectTo: '', pathMatch: 'full' }
  //FALTA LA DE 404 (VER SI APLICABA CON OTRO WILDCARD)
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }