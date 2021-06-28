import { Component, OnInit } from '@angular/core';
import {Movie} from '../shared/movie.model';
import {MovieService} from '../shared/movie.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  movies: Movie[];
  movieTitle: string;
  filteredMovies: Movie[];
  selectedMovie: Movie;

  constructor(private movieService: MovieService,
              private router: Router) { }

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies(): void {
    this.movieService.getMovies()
      .subscribe(
        movies => {
          this.movies = movies;
          this.filteredMovies = movies;
          console.log(movies);
        });
  }

  search(): void {
    if (this.movieTitle === '') {
      this.ngOnInit();
    } else {
      this.filteredMovies = this.movies.filter(res => {
        return res.title.toLocaleLowerCase().match(this.movieTitle.toLocaleLowerCase());
      });
    }
  }

  goToDetails(movie: Movie): void{
    console.log(movie.id);
    this.router.navigate(['movieapp/movie/details', movie.id]);
  }
}
