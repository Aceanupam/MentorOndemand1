import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { Training } from '../models/training.model';
import { TrainingService } from '../training/training.service';
import { UtrainingService } from './utraining.service';

@Component({
  selector: 'app-utraining',
  templateUrl: './utraining.component.html',
  styles: []
})
export class UtrainingComponent implements OnInit {

  users: User[];
  trainings:Training[];
  regTraining:Training;
  constructor(private router: Router, private utrainingService: UtrainingService, private trainingService: TrainingService) {

  }

  ngOnInit() {
    this.trainingService.getTraining().subscribe( data =>{
      this.trainings = data;
      });
  };

  deleteUser(user: User): void {
    this.utrainingService.deleteUser(user)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
      })
  };

  register(training: Training)
  {
    console.log(training);
    training.user= JSON.parse(localStorage.getItem('userData'));
    alert(training.users.firstName+"  "+training.mentor.name);
    localStorage.setItem('trainingData',JSON.stringify(training)); 
    this.router.navigate(['payment']); 
  }

}


