import {Routes} from "@angular/router";
import {UserRegisterComponent} from "./user/register/user.register.component";
import {GeneralHomeComponent} from "./general/home/general.home.component";

export const AppRoutes : Routes = [
  { path: '', component: GeneralHomeComponent },
  { path: 'user/register', component: UserRegisterComponent}
];

// Matched van boven naar beneden. Wanneer we /new route onder /:id plaatsen
// zal /new gemapped worden op /:id. Dus hij zal new willen invullen bij /:id
// oppassen!
