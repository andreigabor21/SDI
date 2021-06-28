import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegistryComponent} from './registry/registry.component';

const routes: Routes = [
  {path: 'registry', component: RegistryComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
