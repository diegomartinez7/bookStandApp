import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  user: any = null;

  constructor(
    private authService: AuthService,
    private storageService: StorageService
  ) { }

  ngOnInit(): void {
    this.user = this.storageService.getUser();
    console.log(this.user);
  }

  logout(): void{
    this.authService.logout().subscribe({
      next: async res => {
        console.log(res);
        await this.storageService.clean();
        window.location.reload();
      },
      error: err => {
        console.log(err);
        //ENVIAR MENSAJE (dialog) DE ERROR
      }
    });
    
  }

}
