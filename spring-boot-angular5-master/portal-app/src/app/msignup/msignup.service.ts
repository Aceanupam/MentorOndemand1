import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Mentor } from '../models/mentor.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MsignupService {

  constructor(private http:HttpClient) {}

  private mentorUrl = 'http://localhost:8090/mentors';
  //private mentorUrl = '/api';

  public getMentors() {
    return this.http.get<Mentor[]>(this.mentorUrl);
  }

  public Validate(userName: String) {
    return this.http.get<boolean>(this.mentorUrl+ "/check/" + userName );
  }

  public deleteMentor(mentor) {
    return this.http.delete(this.mentorUrl + "/"+ mentor.mentorId);
  }

  public createMentor(mentor) {
    return this.http.post<Mentor>(this.mentorUrl, mentor);
  }

}
