import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {MovieComponent} from './movies/movie/movie.component';
import {MovieDetailsComponent} from './movies/movie-details/movie-details.component';

const routes: Routes = [
  {path: 'movieapp/movies', component: MovieComponent},
  {path: 'movieapp/movie/details/:id', component: MovieDetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
