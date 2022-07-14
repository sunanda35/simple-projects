import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { BooksdataService } from 'src/app/booksdata.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  searchValue = '';
  bookData: any;
  favBookData: any;
  constructor(private bookDataService: BooksdataService) {}
  ngOnInit(): void {
    localStorage.setItem('favorite', JSON.stringify([]));
    this.bookDataService.getRecomendedBookData().subscribe((data: any) => {
      const recomentData = data.works?.map((e: any) => {
        return {
          ...e,
          ['cover_edition_key']: e['cover_edition_key']
            ? `https://covers.openlibrary.org/b/olid/${e['cover_edition_key']}-L.jpg`
            : 'https://images-na.ssl-images-amazon.com/images/I/51EYWoYlA2S._SX413_BO1,204,203,200_.jpg',
        };
      });
      this.bookData = recomentData;
      console.log(this.bookData);
    });
  }
  @Output()
  searchTextChanged: EventEmitter<string> = new EventEmitter<string>();
  searchTextChange() {
    this.searchTextChanged.emit(this.searchValue);
  }

  addFavoriteData(url: any) {
    console.log(url);
    const getLocalData: any = localStorage.getItem('favorite');
    console.log(getLocalData);
    // convrt string to json
    var setLocalData = JSON.parse(getLocalData);
    setLocalData.push(url);
    setLocalData = [...new Set(setLocalData)];
    this.favBookData = setLocalData;
    localStorage.setItem('favorite', JSON.stringify(setLocalData));
  }
  removeFavoriteData(url: any) {
    const getLocalData: any = localStorage.getItem('favorite');
    const setLocalData = JSON.parse(getLocalData).filter((e: any) => e != url);
    this.favBookData = setLocalData;
    localStorage.setItem('favorite', JSON.stringify(setLocalData));
  }

  search() {
    if (this.searchValue != '') {
      this.bookDataService.getSearchBookData(this.searchValue).subscribe(
        (res: any) => {
          const searchData = res.docs?.map((e: any) => {
            return {
              ...e,
              ['cover_edition_key']: e['cover_edition_key']
                ? `https://covers.openlibrary.org/b/olid/${e['cover_edition_key']}-L.jpg`
                : 'https://images-na.ssl-images-amazon.com/images/I/51EYWoYlA2S._SX413_BO1,204,203,200_.jpg',
            };
          });
          this.bookData = searchData;
          console.log(this.bookData);
        },
        (err) => {
          console.log(err);
        }
      );
    }
  }
}
