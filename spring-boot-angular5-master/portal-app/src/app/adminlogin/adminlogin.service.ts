import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Admin } from '../models/admin.model';
import { User } from '../models/user.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AdminloginService {

  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8090/admin';
  //private userUrl = '/api';

  public getUsers() {
    return this.http.get<User[]>(this.userUrl);
  }
  public Validate(admin) {
    return this.http.get<Admin[]>(this.userUrl + "/Validate/" + admin.userName + "/" + admin.password);
  }
  public deleteUser(user) {
    return this.http.delete(this.userUrl + "/"+ user.id);
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }

}
