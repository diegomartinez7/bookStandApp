import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const TEST_ENDPOINT = `${environment.apiURL}` + 'test/';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  getPublicContent(): Observable<any> {
    return this.http.get(TEST_ENDPOINT + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(TEST_ENDPOINT + 'user', { responseType: 'text' });
  }
  
  getModeratorBoard(): Observable<any> {
    return this.http.get(TEST_ENDPOINT + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(TEST_ENDPOINT + 'admin', { responseType: 'text' });
  }
}