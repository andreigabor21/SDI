import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {VotingAllComponent} from './voting-all/voting-all.component';
import {VotingService} from "./voting.service";
import {HttpClientModule} from "@angular/common/http";
import {VotingLatestComponent} from './voting-latest/voting-latest.component';

@NgModule({
  declarations: [
    AppComponent,
    VotingAllComponent,
    VotingLatestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [VotingService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
