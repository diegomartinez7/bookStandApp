import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm = new FormGroup({
    username: new FormControl(null, [Validators.required, Validators.maxLength(50)]),
    password: new FormControl(null, [Validators.required, Validators.minLength(8)])
  });

  constructor(
    private router: Router,
    private authService: AuthService,
    private storageService: StorageService
  ) { }

  ngOnInit(): void {
    // if (this.storageService.isLoggedIn()) {
      //MANDAR AL USUARIO DE REGRESO A LA PÁGINA PRINCIPAL (ruta '')
      // this.router.navigate(['']);
    // }
  }

  login(): void {
    if (!this.loginForm.valid) {
      return;
    }

    this.authService.login(
      this.loginForm.value.username,
      this.loginForm.value.password
    ).subscribe({
      next: data => {
        console.log(data);
        this.storageService.saveUser(data);
        //MANDAR MENSAJE (dialog) DE ÉXITO Y AL ACEPTARLO ENVIAR A LA PÁGINA PRINCIPAL (ruta '')
        this.router.navigate(['']);
      },
      error: err => {
        let errorMessage = err.error.message;
        console.log(errorMessage);
        //ENVIAR MENSAJE (dialog) DE ERROR
      }
    });
  }

}
