import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/services/auth.service';
import { WishListService } from 'src/services/wish-list.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  wishList: any = [];
  loadingWishList: boolean = false;
  constructor(
    private wishListService: WishListService,
    private authService: AuthService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    !this.authService.isLoggedIn() ? this.router.navigate(['/login']) : null;
    this.getWishList();
  }

  getWishList() {
    this.loadingWishList = true;
    const ID: any = localStorage.getItem('id');
    this.wishListService.getWishlist(ID).subscribe(
      (data: any) => {
        this.wishList = data;
        console.log(data);
        this.loadingWishList = false;
      },
      (err) => {
        this.toastr.error(err?.error || 'Something went wrong');
        this.loadingWishList = false;
      }
    );
  }
  removeWishList(pId: any) {
    this.loadingWishList = true;
    const user_id: any = localStorage.getItem('id');
    this.wishListService.removeFromWishlist(pId, user_id).subscribe(
      (data: any) => {
        this.toastr.warning('Product Removed to wishlist');
        this.getWishList();
        this.loadingWishList = false;
      },
      (err) => {
        this.toastr.error(err?.error || 'Something went wrong');
        this.loadingWishList = false;
      }
    );
  }
}
