import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookComponent } from './components/book/book.component';
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