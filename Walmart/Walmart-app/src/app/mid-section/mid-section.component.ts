import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { recomendSearcQuery } from 'src/environments/environment';
import { AuthService } from 'src/services/auth.service';
import { DataService } from 'src/services/data.service';
import { WishListService } from 'src/services/wish-list.service';

@Component({
  selector: 'app-mid-section',
  templateUrl: './mid-section.component.html',
  styleUrls: ['./mid-section.component.css'],
})
export class MidSectionComponent implements OnInit {
  searchValue = '';
  pData: any = [];
  loadingP: boolean = false;
  wishListIds: any = [];
  isLoggedIn = false;
  constructor(
    private authService: AuthService,
    private dataService: DataService,
    private wishListService: WishListService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.authService.isLoggedIn();
    this.getWishList();
    this.fetchProducts();
  }
  @Output()
  searchTextChanged: EventEmitter<string> = new EventEmitter<string>();
  searchTextChange() {
    this.searchTextChanged.emit(this.searchValue);
  }
  fetchProducts() {
    this.loadingP = true;
    const query = this.searchValue || recomendSearcQuery;
    this.pData = [];
    this.dataService.recomendedProducts(query).subscribe(
      (data: any) => {
        console.log(data);
        data?.item?.props?.pageProps?.initialData?.searchResult?.itemStacks?.map(
          (d: any) => {
            this.pData.push(
              ...d.items.filter((item: any) => item.__typename === 'Product')
            );
          }
        );
        this.loadingP = false;
      },
      (err) => {
        this.loadingP = false;
        this.toastr.error(err?.error?.message || 'Too many requests');
      }
    );
  }

  getWishList() {
    const ID: any = localStorage.getItem('id');
    this.authService.isLoggedIn() &&
      this.wishListService.getWishlist(ID).subscribe((data: any) => {
        this.wishListIds = data?.map((d: any) => d.id);
        console.log(this.wishListIds);
      });
  }

  addToWishlist(product: any) {
    if (!this.isLoggedIn) console.log('Not logged in yet');

    this.isLoggedIn &&
      this.wishListService.addToWishlist(product).subscribe(
        (data: any) => {
          this.toastr.success('Product added to wishlist');
          this.getWishList();
        },
        (err) => {
          this.toastr.error(err?.error || 'Something went wrong');
        }
      );
  }
}
