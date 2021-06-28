import { Component, OnInit } from '@angular/core';
import {MovieService} from '../shared/movie.service';
import {Movie} from '../shared/movie.model';
import {Actor} from '../shared/actor.model';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  movieYear: number;
  movies: Movie[];
  lessThan: boolean;

  constructor(private movieService: MovieService) { }

  ngOnInit(): void {
  }

  handleChange(lessThan: boolean): void {
    this.movieService.getMoviesByYear(this.movieYear, lessThan)
      .subscribe(
        movies => {
          this.movies = movies;
          this.movies.sort((a, b) => b.year - a.year);
          console.log(movies);
        });
  }

  showCast(): void {
    this.movieService.getMoviesByYearWithActors(this.movieYear, this.lessThan)
      .subscribe(
        movies => {
          this.movies = movies;
          this.movies.sort((a, b) => b.year - a.year);
          console.log(movies);
        });
  }

  deleteActor(movie: Movie, actor: Actor): void {
    console.log(movie, actor);
    this.movieService.deleteActorFromMovie(movie.id, actor.id)
      .subscribe(_ => movie.actors = movie.actors.filter(act => act !== actor));
  }
}
