import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  baseUrl = environment.baseUrl;

  constructor() {
  }

  async authenticate(username: string) {
    localStorage.setItem('username', username);
  }

  isUserLoggedIn() {
    let user = localStorage.getItem('username');
    return !(user === null);
  }

  logOut() {
    localStorage.removeItem('username');
  }
}
