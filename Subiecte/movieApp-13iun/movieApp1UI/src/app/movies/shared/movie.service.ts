import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Movie} from './movie.model';
import {Observable} from 'rxjs';
import {Actor} from '../../actors/shared/actor.model';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private moviesUrl = 'http://localhost:8080/movieapp';
  private actorsUrl = 'http://localhost:8080/movieapp/actors';

  constructor(private httpClient: HttpClient) { }

  getMovies(): Observable<Movie[]> {
    return this.httpClient.get<Movie[]>(`${this.moviesUrl}/movies`);
  }

  getMovie(id: number): Observable<Movie> {
    console.log(id);
    return this.httpClient.get<Movie>(`${this.moviesUrl}/movie/${id}`);
  }

  getAvailableActors(): Observable<Actor[]> {
    return this.httpClient.get<Actor[]>(`${this.actorsUrl}/available`);
  }

  addActorToMovie(movieId: number, actorId: number): any {
    console.log(movieId, actorId);
    return this.httpClient.post<any>(`http://localhost:8080/movieapp/movie/new/${movieId}/${actorId}`,
      {});
  }
}
