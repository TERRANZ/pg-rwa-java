import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PersonsService} from "./services/persons.service";
import {PersonsComponent} from "./modules/persons/persons.component";
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    PersonsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [PersonsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
