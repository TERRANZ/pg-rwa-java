import {AuthenticationService} from "../../services/authentication.service";
import {Router} from "@angular/router";
import {Component} from "@angular/core";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  constructor(private router: Router,
              private loginservice: AuthenticationService) {
  }

  checkLogin() {
    if (this.loginservice.isUserLoggedIn()) {
      this.router.navigate(['persons']);
    } else {
      this.router.navigate(['']);
    }
  }
}
