import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/user.model';
import { Mentor } from '../models/mentor.model';
import { Training } from '../models/training.model';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TrainingService {

  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8090/user';
  private mentorUrl = 'http://localhost:8090/mentors';
  private trainingUrl = 'http://localhost:8090/training';
  //private userUrl = '/api';

  public getUsers() {
    return this.http.get<User[]>(this.userUrl);
  }

  public getMentors() {
    return this.http.get<Mentor[]>(this.mentorUrl);
  }

  public getTraining() {
    return this.http.get<Training[]>(this.trainingUrl);
  }

  public getDateWiseTraining(dateWiseTraining){
    return this.http.get<Training[]>(this.trainingUrl+"/findByStartDateBetween/"+dateWiseTraining.startDate+"/"+dateWiseTraining.endDate);

  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + "/" + user.userId);
  }

  public deleteMentor(mentor) {
    return this.http.delete(this.mentorUrl + "/" + mentor.mentorId);
  }

  public deleteTraining(training) {
    return this.http.delete(this.trainingUrl + "/" + training.trainingId);
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }

  public createTraining(training) {
    alert(training.description);
    return this.http.post<Training>(this.trainingUrl, training);
  }

  public check(trainingId: number) {
    return this.http.get<boolean>(this.trainingUrl + "/check/" + trainingId);
  }

}
