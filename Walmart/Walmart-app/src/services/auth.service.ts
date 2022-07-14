import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { authBaseUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(data: any): Observable<any> {
    return this.http.post(`${authBaseUrl}/users/login`, data);
  }
  register(data: any): Observable<any> {
    console.log(data);
    return this.http.post(`${authBaseUrl}/users/register`, data);
  }
  updateUser(pass: String): Observable<any> {
    const id = localStorage.getItem('id');
    return this.http.get(
      `${authBaseUrl}/users/update-user?id=${id}&pass=${pass}`
    );
  }
  loginUser(user: any) {
    localStorage.setItem('token', user?.token);
    localStorage.setItem('id', user?.id);
    localStorage.setItem('userName', user?.userName);
    localStorage.setItem('email', user?.email);
    localStorage.setItem('fName', user?.fname);
    localStorage.setItem('lName', user?.lname);
    return true;
  }
  isLoggedIn() {
    let token = localStorage.getItem('token');
    if (token == undefined || token == null || token == '') {
      return false;
    } else {
      return true;
    }
  }
  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('id');
    localStorage.removeItem('userName');
    localStorage.removeItem('email');
    localStorage.removeItem('fName');
    localStorage.removeItem('lName');

    return true;
  }
}
