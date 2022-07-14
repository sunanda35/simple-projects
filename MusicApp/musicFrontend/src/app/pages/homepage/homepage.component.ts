import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { NgxUiLoaderService } from 'ngx-ui-loader';
import { ApiService } from 'src/services/api.service';
import { AuthServiceService } from 'src/services/auth-service.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss'],
})
export class HomepageComponent implements OnInit {
  searchValue: string = '';
  tracks: any;
  dataLength: number = 0;
  loading: boolean = false;
  searchDataValue: boolean = false;

  constructor(
    private apiService: ApiService,
    private authService: AuthServiceService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.loading = true;
    this.recomended();
  }

  @Output()
  searchTextChanged: EventEmitter<string> = new EventEmitter<string>();
  searchTextChange() {
    this.searchTextChanged.emit(this.searchValue);
  }

  recomended() {
    this.searchDataValue = false;
    this.apiService.recomendData().subscribe(
      (res: any) => {
        this.tracks = res?.tracks || [];
        this.dataLength = this.tracks?.length;
        this.loading = false;
        console.log(this.tracks);
      },
      (err) => {
        this.loading = false;
        this.toastr.error('Something Went Wrong');
      }
    );
  }

  addFavorite(id: number) {
    this.apiService.addFavoriteData(id).subscribe((res: any) => {
      this.toastr.success('Added to Favorite Successfully!');
    });
  }
  logoutUser() {
    console.log('logout');
    this.authService.logout();
    this.router.navigate(['/login']);
    this.toastr.success('Logged Out! Thanks for coming :)');
  }
}
