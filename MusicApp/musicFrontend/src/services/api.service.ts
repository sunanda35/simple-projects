import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { apiBaseUrl, favoriteBaseUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  constructor(private http: HttpClient) {}
  recomendData() {
    return this.http.get(`${apiBaseUrl}/data/recomended`);
  }
  searchData(data: any) {
    return this.http.get(
      `${apiBaseUrl}/data/search${data ? `?q=${data}` : ''}`
    );
  }
  getFavoriteData() {
    const userId = localStorage.getItem('id');
    return this.http.get(`${favoriteBaseUrl}/data/favourite?id=${userId}`);
  }
  addFavoriteData(tId: any) {
    const postData = {
      id: tId.replace(/\D/g, ''),
      mIds: `${tId}`,
      user_id: localStorage.getItem('id'),
    };
    return this.http.post(`${favoriteBaseUrl}/data/favourite`, postData);
  }
  deleteFavoriteData(id: any) {
    return this.http.delete(
      `${favoriteBaseUrl}/data/favourite/del${id ? `?id=${id}` : ''}`
    );
  }
}
