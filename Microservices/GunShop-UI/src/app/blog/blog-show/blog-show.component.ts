import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {BlogService} from '../blog.service';
import {Article} from '../article-model';

@Component({
  selector: 'app-blog-show',
  templateUrl: './blog-show.component.html',
  styleUrls: ['./blog-show.component.css']
})
export class BlogShowComponent implements OnInit {

  articles: Article[];

  constructor(private service: BlogService, private router: Router) { }

  ngOnInit(): void {
    this.getArticles();
  }

  getArticles(): void {
    this.service.getArticles()
      .subscribe(
        articles => {
          this.articles = articles;
          console.log(this.articles);
        }
      );
  }

}
