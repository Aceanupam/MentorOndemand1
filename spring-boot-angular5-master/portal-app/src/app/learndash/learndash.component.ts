import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { Payment } from '../models/payment.model';
import { Training } from '../models/training.model';
import { LearndashService } from './learndash.service';

@Component({
  selector: 'app-learndash',
  templateUrl: './learndash.component.html',
  styles: []
})
export class LearndashComponent implements OnInit {

  users: User[];
  userTraining:Training[];
  userPayment:Payment[];
  userProfile :User=new User();
  userId;
  userProfileFlag=false;
  trainingListFlag=false;
  paymentListFlag=false;

  constructor(private router: Router, private learndashService: LearndashService) {

  }
  iswidth="30%";

  getAllTraining(){
    this.trainingListFlag=true;
    this.userProfileFlag=false;
    this.paymentListFlag=false;
    this.learndashService.getTrainings(this.userId)
      .subscribe( data => {
        this.userTraining =  data;
      });
  };

  /* getAllPayment()
  {
    this.trainingListFlag=false;
    this.userProfileFlag=false;
    this.paymentListFlag=true;
    this.learndashService.getPayments(this.userId)
      .subscribe( data => {
        this.userTraining =  data;
      });
  } */

  viewProfile()
  {
    this.trainingListFlag=false;
    this.userProfileFlag=true;
  };

  ngOnInit() {
    this.trainingListFlag=false;
    this.userProfileFlag=true;
    this.learndashService.getUsers()
      .subscribe( data => {
        this.users =  data;
      
      //localStorage.setItem('userData',JSON.stringify(data));
      var userData= JSON.parse(localStorage.getItem('userData'));
      console.log(userData);
      this.userProfile=userData;
      this.userId=userData.userId;
      document.getElementById("Name").innerHTML=userData.firstName+" "+userData.lastName;
      this.iswidth=userData.progress+"%";
      document.getElementById("previous").innerHTML=userData.progress;

    });
  };

  deleteUser(user: User): void {
    this.learndashService.deleteUser(user)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
      })
  };

}


