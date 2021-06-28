import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistryComponent } from './registry/registry.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    RegistryComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
