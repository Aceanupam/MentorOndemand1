import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/user.model';
import { Mlogin } from '../models/mlogin.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LoginService {

  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8090/user/Validate';
  //private userUrl = '/api';

  public Validate(user) {
    return this.http.get<User>(this.userUrl + "/" + user.userName + "/" + user.password);
  }
  public getUsers() {
    return this.http.get<User[]>(this.userUrl);
  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + "/" + user.id);
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }

}
