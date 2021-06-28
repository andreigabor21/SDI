import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Article} from './article-model';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  private url = 'http://localhost:8080/articles';

  constructor(private http: HttpClient) { }

  getArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(this.url);
  }

  addArticle(title: string, body: string): Observable<any> {
    return this.http.post(this.url, new Article(title, body));
  }
}
