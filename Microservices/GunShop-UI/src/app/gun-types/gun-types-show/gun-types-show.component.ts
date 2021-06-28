import { Component, OnInit } from '@angular/core';
import {Client} from '../../clients/client-model';
import {ClientService} from '../../clients/client.service';
import {Router} from '@angular/router';
import {GunType} from '../gunType-model';
import {GunTypeService} from '../gun-type.service';

@Component({
  selector: 'app-gun-types-show',
  templateUrl: './gun-types-show.component.html',
  styleUrls: ['./gun-types-show.component.css']
})
export class GunTypesShowComponent implements OnInit {

  gunTypes: GunType[];

  constructor(private service: GunTypeService, private router: Router) { }

  ngOnInit(): void {
    this.getGunTypes();
  }

  getGunTypes(): void {
    this.service.getGunTypes()
      .subscribe(
        gt => {
          this.gunTypes = gt.gunTypes;
          console.log(this.gunTypes);
        }
      );
  }

}
