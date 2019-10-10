import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/user.model';
import { Mentor } from '../models/mentor.model';
import { Technology } from '../models/technology.model';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TechnologyService {

  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8090/user';
  private mentorUrl = 'http://localhost:8090/mentors';
  private technologyUrl = 'http://localhost:8090/technology';
  //private userUrl = '/api';

  public getUsers() {
    return this.http.get<User[]>(this.userUrl);
  }

  public getMentors() {
    return this.http.get<Mentor[]>(this.mentorUrl);
  }

  public getTechnology() {
    return this.http.get<Technology[]>(this.technologyUrl);
  }


  public deleteUser(user) {
    return this.http.delete(this.userUrl + "/" + user.userId);
  }

  public deleteMentor(mentor) {
    return this.http.delete(this.mentorUrl + "/" + mentor.mentorId);
  }

  public deleteTechnology(technology) {
    return this.http.delete(this.technologyUrl + "/" + technology.technologyId);
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }

  public createTechnology(technology) {
    alert(technology.description);
    return this.http.post<Technology>(this.technologyUrl, technology);
  }

  public check(technologyName: String) {
    return this.http.get<boolean>(this.technologyUrl + "/check/" + technologyName);
  }

}
