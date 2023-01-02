import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const AUTH_ENDPOINT = `${environment.apiURL}` + 'auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_ENDPOINT + 'signin',
      {
        username,
        password,
      },
      httpOptions
    );
  }

  register(nombre: string, username: string, email: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_ENDPOINT + 'signup',
      {
        nombre,
        username,
        email,
        password,
      },
      httpOptions
    );
  }

  logout(): Observable<any> {
    return this.http.post(AUTH_ENDPOINT + 'signout', {}, httpOptions);
  }
}