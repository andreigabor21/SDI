import { Component, OnInit } from '@angular/core';
import {PersonService} from './person.service';
import {Person} from './person.model';

@Component({
  selector: 'app-registry',
  templateUrl: './registry.component.html',
  styleUrls: ['./registry.component.css']
})
export class RegistryComponent implements OnInit {

  name: string;
  persons: Person[] = [];
  empty = false;

  constructor(private personService: PersonService) { }

  ngOnInit(): void {
  }

  search(): void {
    this.personService.searchPersons(this.name)
      .subscribe(persons => {
          this.persons = persons;
          if (persons.length === 0) {
            this.empty = true;
          }
        }
      );
  }
}
