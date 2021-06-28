import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SensorsAllComponent} from './sensors/sensors-all/sensors-all.component';
import {SensorsNameComponent} from './sensors/sensors-name/sensors-name.component';

const routes: Routes = [
  {path: 'all', component: SensorsAllComponent},
  {path: 'sensors', component: SensorsNameComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
