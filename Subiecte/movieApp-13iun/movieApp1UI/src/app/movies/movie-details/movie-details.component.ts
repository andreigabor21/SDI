import { Component, OnInit } from '@angular/core';
import {Movie} from '../shared/movie.model';
import {MovieService} from '../shared/movie.service';
import {ActivatedRoute, Params} from '@angular/router';
import {switchMap} from 'rxjs/operators';
import {Actor} from '../../actors/shared/actor.model';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  movie: Movie | undefined;
  isVisible = false;
  actors: Actor[];
  selectedActor: Actor | undefined;

  constructor(private movieService: MovieService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.movieService.getMovie(+params.id)))
      .subscribe(movie => this.movie = movie);
    this.loadActors();
  }

  loadActors(): void {
    this.movieService.getAvailableActors()
      .subscribe(availableActors => {
        console.log(availableActors);
        this.actors = availableActors;
      });
  }

  addNewActor(): void {
    this.movie.actors.push(this.selectedActor);

    this.actors = this.actors.filter(item => item !== this.selectedActor);

    const movieId = +this.route.snapshot.paramMap.get('id');
    const actorId = this.selectedActor.id;
    this.movieService.addActorToMovie(movieId, actorId)
      .subscribe();
  }
}
