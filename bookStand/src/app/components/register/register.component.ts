import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomValidator } from 'src/app/helpers/custom-validator';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm = new FormGroup({
    nombre: new FormControl(null, [Validators.required, Validators.maxLength(70)]),
    username: new FormControl(null, [Validators.required, Validators.maxLength(50)]),
    email: new FormControl(null, [Validators.required, Validators.email]),
    password: new FormControl(null, [Validators.required, Validators.minLength(8)]),
    passwordConfirm: new FormControl(null, [Validators.required])
  },
    { validators: CustomValidator.passwordsMatching }
  );

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
  }

  register(){
    if (!this.registerForm.valid) {
      return;
    }

    this.authService.register(
      this.registerForm.value.nombre,
      this.registerForm.value.username,
      this.registerForm.value.email,
      this.registerForm.value.password
    ).subscribe({
      next: data => {
        console.log(data);
        this.router.navigate(['/login']);
        //ENVIAR MENSAJE (dialog) DE ÉXITO
      },
      error: err => {
        let errorMessage = err.error.message;
        console.log(errorMessage);
        //ENVIAR MENSAJE (dialog) DE ERROR
      }
    });
  }
}
