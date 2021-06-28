import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ClientsShowComponent } from './clients/clients-show/clients-show.component';
import {AppRoutingModule} from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { GunTypesShowComponent } from './gun-types/gun-types-show/gun-types-show.component';
import { AmmoShowComponent } from './ammo/ammo-show/ammo-show.component';
import { BlogShowComponent } from './blog/blog-show/blog-show.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientsShowComponent,
    GunTypesShowComponent,
    AmmoShowComponent,
    BlogShowComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
