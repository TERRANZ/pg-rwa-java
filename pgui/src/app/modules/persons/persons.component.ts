import {Component} from "@angular/core";
import {Person} from "../../model/Person";
import {PersonsService} from "../../services/persons.service";

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.scss']
})
export class PersonsComponent {
  persons: Person[];

  ngOnInit() {
    this.loadPersons();
  }

  constructor(private personsService: PersonsService) {
  }

  private async loadPersons() {
    this.persons = await this.personsService.getPersons();
  }
}
