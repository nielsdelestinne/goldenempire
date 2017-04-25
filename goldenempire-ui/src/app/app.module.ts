import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {UserRegisterComponent} from "./user/register/user.register.component";
import {UserService} from "./user/user.service";
import {GeneralHomeComponent} from "./general/home/general.home.component";
import {RouterModule} from "@angular/router";
import {AppRoutes} from "./app.routes";

@NgModule({
  declarations: [
    AppComponent,
    UserRegisterComponent,
    GeneralHomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(AppRoutes),
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
