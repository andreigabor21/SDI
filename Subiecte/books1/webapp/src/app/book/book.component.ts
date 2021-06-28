import { Component, OnInit } from '@angular/core';
import {Author} from './author.model';
import {BookService} from './book.service';
import {Book} from './book.model';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  authors: Author[];
  books: Book[];
  selectedAuthor: Author = new Author();
  years: number[];
  selectedYear: number;

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.loadAuthors();
  }

  loadAuthors(): void {
    this.bookService.filterBooks(0, 0)
      .subscribe(books => {
        this.books = books;
        console.log(books);
        this.authors = books.map(book => book.authorDto);
        this.authors = [...new Map(this.authors.map(item => [item.id, item])).values()];

        this.years = books.map(book => book.year);
        this.years = [...new Set(this.years)];
      });
  }

  filterBooks(): void {
    if (this.selectedAuthor.id === undefined) {
      this.selectedAuthor.id = 0;
    }
    if (this.selectedYear === undefined) {
      this.selectedYear = 0;
    }
    this.bookService.filterBooks(this.selectedAuthor.id, this.selectedYear)
      .subscribe(books => {
        this.books = books;
        console.log(this.books);
      });
  }
}
