import {Injectable} from "@angular/core";
import User from "./user";
import {Http, Headers} from "@angular/http";
import "rxjs/add/operator/toPromise";

@Injectable()
export class UserService {

  private static URL_PATH = "/api/users/";
  private static HEADERS = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) {}

  registerUser(user: User): Promise<User> {
    return this.http.post(`${UserService.URL_PATH}`, JSON.stringify(user), {headers: UserService.HEADERS})
      .toPromise()
      .then(response => response.json() as User)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
