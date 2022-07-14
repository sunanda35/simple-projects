import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface IFavouriteNews {
  userId: string;
  title: string;
  description: string;
  content: string;
  publishedAt: string;
  sourceWebsiteName: string;
  url: string;
  urlToImage: string;
}

@Injectable({
  providedIn: 'root',
})
export class NewsapiService {
  constructor(private _http: HttpClient) {}

  private _newsApiBaseURL = 'http://localhost:9000/news';

  ///favourite url
  url = 'http://localhost:8081/api/news';

  tcHeadlines(category: string): Observable<any> {
    let cat = category;
    if (!category) cat = 'all';
    return this._http.get(`${this._newsApiBaseURL}/recomend?category=${cat}`);
  }
  getSearchResult(search: string) {
    return this._http.get(`${this._newsApiBaseURL}/search?q=${search}`);
  }

  getFavourite(user: string) {
    return this._http.get(`${this.url}/${user}`);
  }

  addFavourites(data: IFavouriteNews) {
    return this._http.post(`${this.url}`, data);
  }

  deleteFavourite(id: string) {
    return this._http.delete(`${this.url}/${id}`);
  }
}
