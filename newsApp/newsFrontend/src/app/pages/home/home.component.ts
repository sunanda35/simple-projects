import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {
  IFavouriteNews,
  NewsapiService,
} from 'src/app/services/newsapi.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  user: any;
  category: any;
  searchTerm = '';

  constructor(
    private userService: UserService,
    private api: NewsapiService,
    private routeSanapShot: ActivatedRoute
  ) {
    this.userService.user.subscribe({
      next: (data) => {
        this.user = data;
        this.routeSanapShot.params.subscribe((data: any) => {
          console.log(data);
          this.category = data.category;
          this.api.tcHeadlines(data.category).subscribe((result) => {
            console.log(result.articles);
            this.topHeadlinesData = result.articles;
          });
        });
      },
    });
  }

  //display headlines data
  public topHeadlinesData: any = [];

  ngOnInit(): void {}
  searchData() {
    this.category = this.searchTerm;
    this.api.getSearchResult(this.searchTerm).subscribe((result: any) => {
      this.topHeadlinesData = result.articles;
    });
  }

  @Output()
  searchTextChanged: EventEmitter<string> = new EventEmitter<string>();
  searchTextChange() {
    this.searchTextChanged.emit(this.searchTerm);
  }

  addFavourite(news: any) {
    const data: IFavouriteNews = {
      userId: this.user.username,
      title: news.title,
      description: news.description,
      content: news.content,
      url: news.url,
      urlToImage: news.urlToImage,
      publishedAt: news.publishedAt,
      sourceWebsiteName: news.source.name,
    };

    console.log(data);

    this.api.addFavourites(data).subscribe({
      next: (value) => {
        alert('added to favourite');
      },
    });
  }
  deleteFavourite(news: any) {}
}
