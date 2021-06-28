import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {RouterModule, Routes} from '@angular/router';
import {AppRoutingModule} from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { MovieComponent } from './movies/movie/movie.component';
import {FormsModule} from '@angular/forms';
import { MovieDetailsComponent } from './movies/movie-details/movie-details.component';

@NgModule({
  declarations: [
    AppComponent,
    MovieComponent,
    MovieDetailsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
