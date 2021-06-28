import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieComponent } from './movie/movie.component';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    MovieComponent
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
