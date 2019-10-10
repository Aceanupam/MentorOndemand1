import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Training } from '../models/training.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MtrainingService {

  constructor(private http:HttpClient) {}

  private trainingUrl = 'http://localhost:8090/training';
  //private userUrl = '/api';

  /* public getUsers() {
    return this.http.get<User[]>(this.userUrl);
  }
*/
  public deleteTraining(training) {
    return this.http.delete(this.trainingUrl + "/"+ training.trainingId);
  }
/*
  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  } */

  public getTrainingList(mentorId){
    return this.http.get<Training[]>(this.trainingUrl+"/findTrainingByMentorId/" +mentorId);
  }
  public createTraining(addTraining) {
    alert(addTraining.startDate+" "+addTraining.endDate);
    return this.http.post<Training>(this.trainingUrl, addTraining);
  }
}
