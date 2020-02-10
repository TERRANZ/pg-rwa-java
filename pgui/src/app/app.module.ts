import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from "./modules/login/login.component";
import {PersonsService} from "./services/persons.service";
import {AuthenticationService} from "./services/authentication.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [AuthenticationService, PersonsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
