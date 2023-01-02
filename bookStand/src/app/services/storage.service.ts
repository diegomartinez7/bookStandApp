import { Injectable } from '@angular/core';

const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  constructor() {}

  clean(): void {
    window.sessionStorage.clear();
  }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    let userJSON: any = null;
    if (user) {
      userJSON = JSON.parse(user);
    }
    return userJSON;
  }

  public isLoggedIn(): boolean {
    const user = window.sessionStorage.getItem(USER_KEY);
    let logged = false;
    if (user) {
      logged = true;
    }
    return logged;
  }

  // public isTokenExpired(token: string) {
  //   const expiry = (JSON.parse(atob(token.split('.')[1]))).exp;
  //   return expiry * 1000 > Date.now();
  // }
}