import { Component, OnInit } from '@angular/core';
import {User} from '../shared/user.model';
import {UserService} from '../shared/user.service';
import {ActivatedRoute, Params} from '@angular/router';
import {switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  objects: User[];
  userName: string;

  constructor(private userService: UserService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getUserById();
  }

  getUserById(): void{
    this.route.params
      .pipe(switchMap((params: Params) => this.userService.getUserName(+params.id)))
      .subscribe(name => {
        console.log(name);
        this.userName = name.name;
      });
  }

}
