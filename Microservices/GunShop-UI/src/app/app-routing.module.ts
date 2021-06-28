import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ClientsShowComponent} from './clients/clients-show/clients-show.component';
import {GunTypesShowComponent} from './gun-types/gun-types-show/gun-types-show.component';
import {AmmoShowComponent} from './ammo/ammo-show/ammo-show.component';
import {BlogShowComponent} from './blog/blog-show/blog-show.component';

const routes: Routes = [
  {path: 'clients', component: ClientsShowComponent},
  {path: 'gun-types', component: GunTypesShowComponent},
  {path: 'bullets', component: AmmoShowComponent},
  {path: 'articles', component: BlogShowComponent}
  /*{path: 'clients-new', component: ClientNewComponent},
  {path: 'client/detail/:id', component: ClientDetailComponent},

  {path: 'gun-providers', component: GunProviderComponent},
  {path: 'gun-provider/detail/:id', component: GunProviderDetailComponent},
  {path: 'gun-providers-new', component: GunProviderNewComponent},

  {path: 'gun-types', component: GunTypeComponent},
  {path: 'gun-type/detail/:id', component: GunTypeDetailComponent},
  {path: 'gun-types-new', component: GunTypeNewComponent},

  {path: 'rentals', component: RentalComponent},*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
