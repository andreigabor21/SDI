import { Component, OnInit } from '@angular/core';
import {User} from '../shared/user.model';
import {Follower} from '../shared/follower.model';
import {UserService} from '../shared/user.service';
import {switchMap} from 'rxjs/operators';
import {ActivatedRoute, Params} from '@angular/router';

@Component({
  selector: 'app-user-followers',
  templateUrl: './user-followers.component.html',
  styleUrls: ['./user-followers.component.css']
})
export class UserFollowersComponent implements OnInit {

  user: User;

  constructor(private userService: UserService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.userService.getUserWithFollowers(+params.id)))
      .subscribe(user => {
        console.log(user);
        this.user = user;
      });
  }

}
