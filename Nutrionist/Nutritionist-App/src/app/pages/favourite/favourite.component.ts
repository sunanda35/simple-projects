import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ApiService } from 'src/services/api.service';
import { AuthServiceService } from 'src/services/auth-service.service';

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.scss'],
})
export class FavouriteComponent implements OnInit {
  favoriteData: any;
  constructor(
    private apiService: ApiService,
    private authService: AuthServiceService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.getFavouriteData();
  }

  deleteFavourite(id: number) {
    this.apiService.deleteFavoriteData(id).subscribe(
      (res: any) => {
        this.favoriteData = res || [];
        this.toastr.success('Deleted Favorite Item Successfully');
      },
      (err) => {
        console.log(err);
      }
    );
  }
  getFavouriteData() {
    this.apiService.getFavoriteData().subscribe(
      (res: any) => {
        this.favoriteData = res || [];
      },
      (err) => {
        console.log(err);
      }
    );
  }
  logoutUser() {
    console.log('logout');
    this.authService.logout();
    this.router.navigate(['/login']);
    this.toastr.success('Logged Out! Thanks for coming :)');
  }
}
