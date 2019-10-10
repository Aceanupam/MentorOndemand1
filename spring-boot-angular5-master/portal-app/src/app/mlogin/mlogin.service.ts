import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Mentor } from '../models/mentor.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MloginService {

  constructor(private http:HttpClient) {}

  private mloginUrl = 'http://localhost:8090/mentors';
  //private mloginUrl = '/api';

  public Validate(mentor) {
    return this.http.get<Mentor>(this.mloginUrl + "/" + mentor.userName + "/" + mentor.password);
  }
  public getMentor() {
    return this.http.get<Mentor[]>(this.mloginUrl);
  }

  public deleteMentor(mlogin) {
    return this.http.delete(this.mloginUrl + "/"+ mlogin.id);
  }

  public createUser(mlogin) {
    return this.http.post<Mentor>(this.mloginUrl, mlogin);
  }

}
