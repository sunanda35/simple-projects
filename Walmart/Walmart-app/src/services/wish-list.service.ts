import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { wishListBaseUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class WishListService {
  constructor(private http: HttpClient) {}
  addToWishlist(pData: any) {
    let params = {
      id: parseInt(pData?.usItemId),
      image: pData?.image,
      name: pData?.name,
      price: pData?.price,
      user_id: localStorage.getItem('id'),
    };
    return this.http.post(`${wishListBaseUrl}/wish-list/add`, params);
  }
  getWishlist(id: String) {
    return this.http.get(`${wishListBaseUrl}/wish-list/user?id=${id}`);
  }
  getPricingData() {
    return this.http.get(`${wishListBaseUrl}/wish-list/pricing`);
  }
  removeFromWishlist(id: any, user_id: String) {
    return this.http.delete(
      `${wishListBaseUrl}/wish-list/del?id=${id}&userId=${user_id}`
    );
  }
}
