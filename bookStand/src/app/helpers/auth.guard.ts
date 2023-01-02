import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { StorageService } from 'src/app/services/storage.service';


@Injectable()
export class AuthGuard implements CanActivate {

    constructor(
        private storageService: StorageService,
        private router: Router
    ) { }

    canActivate(
        route: ActivatedRouteSnapshot
    ): Observable<boolean> | boolean {
        var currentUser = this.storageService.getUser();

        if(route.data.sessionRequired) {
            if(currentUser) {
                return true;
            }
            this.router.navigate(['/login']);
            return false;
        }
        else {
            if(!currentUser) {
                return true;
            }
            this.router.navigate(['/books']);
            return false;
        }
    }
}
