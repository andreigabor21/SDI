import { Component, OnInit } from '@angular/core';
import {Client} from '../shared/client.model';
import {ClientService} from '../shared/client.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  errorMessage: string;
  clients: Client[];
  selectedClient: Client;
  noResults = false;

  constructor(private clientService: ClientService,
              private router: Router,
              private formBuilder: FormBuilder) { }

  findByCityInput: FormGroup = this.formBuilder.group({
    city: ['']
  });

  ngOnInit(): void {
    this.getClients();
  }

  getClients(): void {
    this.clientService.getClients()
      .subscribe(
        clients => {
          this.clients = clients;
          console.log(clients);
        },
          error => this.errorMessage = error
      );
  }

  onSelect(client: Client): void {
    this.selectedClient = client;
  }

  goToDetails(): void {
    this.router.navigate(['/client/detail', this.selectedClient.id]);
  }

  sortByName(): void {
    this.clients.sort((a: Client, b: Client) =>
      (a.name.toLowerCase() > b.name.toLowerCase() ? 1 : -1));
    console.log(this.clients);
  }

  findClientsByCity(): void {
    console.log(this.findByCityInput.value);
    this.clientService.findByCity(this.findByCityInput.value.city)
      .subscribe(
        clients => {
          if (clients.length > 0) {
            this.clients = clients;
            this.noResults = false;
            console.log(clients);
          }
          else {
            console.log('no results');
            this.noResults = true;
          }
        },
        error => this.errorMessage = error
      );
  }
}
