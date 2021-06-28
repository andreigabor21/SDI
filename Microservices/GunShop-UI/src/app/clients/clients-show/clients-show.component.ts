import { Component, OnInit } from '@angular/core';
import {Client, Clients} from '../client-model';
import {Router} from '@angular/router';
import {ClientService} from '../client.service';

@Component({
  selector: 'app-clients-show',
  templateUrl: './clients-show.component.html',
  styleUrls: ['./clients-show.component.css']
})
export class ClientsShowComponent implements OnInit {

  clients: Client[];

  constructor(private service: ClientService, private router: Router) { }

  ngOnInit(): void {
    this.getClients();
  }

  getClients(): void {
    this.service.getClients()
      .subscribe(
        clients => {
          this.clients = clients.clients;
          console.log(clients);
        }
      );
  }

}
