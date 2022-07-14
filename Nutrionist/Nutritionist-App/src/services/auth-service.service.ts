import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { authBaseUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthServiceService {
  constructor(private http: HttpClient) {}

  login(data: any): Observable<any> {
    return this.http.post(`${authBaseUrl}/users/login`, data);
  }
  register(data: any): Observable<any> {
    console.log(data);
    return this.http.post(`${authBaseUrl}/users/register`, data);
  }
  loginUser(res: any) {
    localStorage.setItem('token', res?.token);
    localStorage.setItem('id', res?.id);
    return true;
  }
  isLoggedIn() {
    let token = localStorage.getItem('token');
    if (token == undefined || token == null || token == '') {
      return false;
    } else {
      var header = new Headers({
        Authorization: `${token}`,
      });
      return this.http.post(`${authBaseUrl}/users/authenticate`, header);
    }
  }
  logout() {
    localStorage.removeItem('token');
    return true;
  }
}
