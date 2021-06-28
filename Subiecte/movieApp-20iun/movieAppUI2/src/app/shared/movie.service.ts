import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Movie} from './movie.model';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private moviesUrl = 'http://localhost:8080/movieapp';

  constructor(private httpClient: HttpClient) { }

  getMoviesByYear(year: number, lessThan: boolean): Observable<Movie[]> {
    return this.httpClient.get<Movie[]>(`${this.moviesUrl}/movies?year=${year}&lessThan=${lessThan}`);
  }

  getMoviesByYearWithActors(year: number, lessThan: boolean): Observable<Movie[]> {
    return this.httpClient.get<Movie[]>(`${this.moviesUrl}/movies-actors?year=${year}&lessThan=${lessThan}`);
  }

  deleteActorFromMovie(movieId: number, actorId: number): any {
    return this.httpClient.post<any>(`${this.moviesUrl}/movies/${movieId}/${actorId}`, {});
  }

}
