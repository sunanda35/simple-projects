import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { apiKey, baseApiUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  constructor(private http: HttpClient) {}

  recomendedProducts(q: String) {
    const headers = new HttpHeaders()
      .set('content-type', 'application/json')
      .set('X-RapidAPI-Key', `${apiKey}`)
      .set('X-RapidAPI-Host', 'axesso-walmart-data-service.p.rapidapi.com');
    return this.http.get(
      `${baseApiUrl}?keyword=${q}&page=1&sortBy=best_match`,
      {
        headers: headers,
      }
    );
  }
}
