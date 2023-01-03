import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookComponent } from './components/book/book.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { MainComponent } from './components/main/main.component';

import { httpInterceptorProviders } from './helpers/http.interceptor';
import { AuthGuard } from './helpers/auth.guard';
import { AuthorsComponent } from './components/authors/authors.component';
import { MessageComponent } from './shared/message/message.component';
import { AlertDialogComponent } from './shared/alert-dialog/alert-dialog.component';
import { CatalogueComponent } from './components/catalogue/catalogue.component';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    MainComponent,
    AuthorsComponent,
    MessageComponent,
    AlertDialogComponent,
    CatalogueComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatMenuModule,
    MatCardModule,
    MatButtonModule
  ],
  providers: [httpInterceptorProviders, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
