import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {BulletService} from '../bullet.service';
import {Bullet} from '../bullet-model';

@Component({
  selector: 'app-ammo-show',
  templateUrl: './ammo-show.component.html',
  styleUrls: ['./ammo-show.component.css']
})
export class AmmoShowComponent implements OnInit {

  bullets: Bullet[];

  constructor(private service: BulletService, private router: Router) { }

  ngOnInit(): void {
    this.getClients();
  }

  getClients(): void {
    this.service.getBullets()
      .subscribe(
        b => {
          this.bullets = b;
          console.log(this.bullets);
        }
      );
  }

}
