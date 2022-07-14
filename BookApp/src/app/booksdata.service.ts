import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class BooksdataService {
  constructor(private http: HttpClient) {}

  getRecomendedBookData() {
    let apiurl = 'http://localhost:8081/api/books/recomended';
    return this.http.get(apiurl);
  }
  getSearchBookData(search: any) {
    let apiurl = `http://localhost:8081/api/books/search?q=${search}`;
    return this.http.get(apiurl);
  }
}
