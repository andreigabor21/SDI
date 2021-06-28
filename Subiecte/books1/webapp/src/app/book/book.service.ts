import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from './book.model';

@Injectable({
  providedIn: 'root'
})
export class BookService { // http://localhost:8080/api/books?authorId=0&year=0

  url = 'http://localhost:8080/api/books';

  constructor(private httpClient: HttpClient) { }

  filterBooks(authorId: number, year: number): Observable<Book[]> {
    console.log(`${this.url}?authorId=${authorId}&year=${year}`);
    return this.httpClient.get<Book[]>(`${this.url}?authorId=${authorId}&year=${year}`);
  }
}
