import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserFollowersComponent} from './user-followers/user-followers.component';
import {UserComponent} from './user/user.component';

const routes: Routes = [
  {path: 'blog/user-hello/:id', component: UserComponent},
  {path: 'blog/user-followers/:id', component: UserFollowersComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
