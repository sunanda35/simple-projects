import { Component, OnInit } from '@angular/core';
import { NewsapiService } from 'src/app/services/newsapi.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {
  favouriteNews:any;

  constructor(private newsService:NewsapiService, private userService: UserService) {
    this.userService.user.subscribe({next:value=>{
      const userName = value.username;
    
     this.getFavourite(value.username)
    }})

   }

  ngOnInit(): void {

  }

getFavourite(userName: string){
  this.newsService.getFavourite(userName).subscribe({
    next: data=>{

      this.favouriteNews = data;
    }, error: err=>{
      this.favouriteNews = [];
    }
  })
}

  deleteFavourite(news:any){
    console.log(news);
    this.newsService.deleteFavourite(news.id).subscribe({
      next: ()=>{
     
        alert("Favourite has deleted");
        this.getFavourite(news.userId)
      },
      error: err=>{
        alert("Favourite has deleted");
        this.getFavourite(news.userId)
      }
    })

  }

}
