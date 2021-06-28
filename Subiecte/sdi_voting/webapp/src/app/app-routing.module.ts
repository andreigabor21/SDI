import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {VotingAllComponent} from "./voting-all/voting-all.component";
import {VotingLatestComponent} from "./voting-latest/voting-latest.component";


const routes: Routes = [
  {path: 'voting/all', component: VotingAllComponent},
  {path: 'voting/latest', component: VotingLatestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
