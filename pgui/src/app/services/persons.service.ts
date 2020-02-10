import {HttpClient} from '@angular/common/http';
import {environment} from "../../environments/environment";
import {Person} from "../model/Person";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class PersonsService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) {
  }

  async getPersons() {
    const url = this.baseUrl + '/';
    try {
      return (<Person[]>await this.http.get(url).toPromise());
    } catch (err) {
      console.log(err);
      return null;
    }
  }
}
