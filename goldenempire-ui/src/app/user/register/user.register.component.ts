import {Component, OnInit} from "@angular/core";
import {UserService} from "../user.service";
import User from "../user";

@Component({
  selector: 'app-register',
  templateUrl: 'user.register.component.html',
  styleUrls: ['user.register.component.css']
})
export class UserRegisterComponent implements OnInit {

  private user: User;
  private message: string;

  constructor(private userService: UserService){}

  ngOnInit(): void {
    this.user = new User();
  }

  onRegister(): void {
    this.userService
      .registerUser(this.user)
      .then((user: User) => {
        this.message = `You have been successfully registered, ${user.username}`;
    });
  }

}
