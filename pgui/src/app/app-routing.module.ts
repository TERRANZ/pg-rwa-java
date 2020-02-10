import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./modules/login/login.component";
import {AuthGuardService} from "./services/auth.service";

const routes: Routes = [
  {
    path: '',
    loadChildren: 'app/layout/main/main.layout.module#MainLayoutModule',
    canActivate: [AuthGuardService]
  },
  {path: 'login', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
