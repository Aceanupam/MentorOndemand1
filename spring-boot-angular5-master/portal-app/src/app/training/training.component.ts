import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { Training } from '../models/training.model';
import { Mentor } from '../models/mentor.model';
import { TrainingService } from './training.service';

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styles: []
})
export class TrainingComponent //implements OnInit 
{

  users: User[];
  mentors:Mentor[];
  trainings:Training[];
  dateWiseTrainings:Training[];

  addTraining:Training=new Training();
  getTraining:Training=new Training();
  dateWiseTraining:Training=new Training();
  
  trainingListFlag=false;
  dateWiseTrainingListFlag=false;
  addTrainingFlag=false;
  findTrainingByDateFlag=false;
  
  constructor(private router: Router, private trainingService: TrainingService) {

  }

  ngOnInit() {
    this.dateWiseTrainingListFlag=false;
    this.trainingListFlag=true;
    this.findTrainingByDateFlag=false;
    this.trainingService.getTraining().subscribe( data =>{
      this.trainings = data; 
    });
  }; 
 
  searchByDate(): void{
    this.dateWiseTrainingListFlag=false;
  this.trainingListFlag=false;
  this.findTrainingByDateFlag=true;
  }

  findTrainingByDate(){
    
    this.trainingService.getDateWiseTraining(this.dateWiseTraining).subscribe( data =>{
      this.dateWiseTrainings = data; 
      this.dateWiseTrainingListFlag=true;
      this.trainingListFlag=false;
      this.findTrainingByDateFlag=false;
    });
  }

  TrainingList(): void{
    this.getAllTraining();
    this.trainingListFlag=true;
  }
/*
  removeTechnology(): void {
    this.userFlag=false;
  this.technologyFlag=true;
  this.removeTechnologyFlag=true;
  this.addTechnologyFlag=false;
  this.mentorFlag=false;
  this.removeUserFlag=false;
  this.removeMentorFlag=false;
    this.getAllTechnology();
  };

  removeUser(): void {
    this.userFlag=true;
    this.technologyFlag=false;
    this.removeTechnologyFlag=false;
  this.addTechnologyFlag=false;
    this.removeUserFlag=true;
    this.mentorFlag=false;
    this.removeMentorFlag=false;
    this.getAllUser();
  };

  removeMentor(): void {
    this.userFlag=false;
    this.removeUserFlag=false;
    this.removeTechnologyFlag=false;
  this.addTechnologyFlag=false;
    this.technologyFlag=false;
    this.mentorFlag=true;
    this.removeMentorFlag=true;
    this.getAllMentor();
  };

  userList(): void {
    this.mentorFlag=false;
    this.removeTechnologyFlag=false;
  this.addTechnologyFlag=false;
    this.technologyFlag=false;
    this.userFlag=true;
    this.removeUserFlag=false;
    this.removeMentorFlag=false;
    this.getAllUser();
  };

  getAllUser(): void {
    this.admindashService.getUsers()
      .subscribe( data => {
        this.users = data; 
      })
  };

  mentorList(): void {
    this.mentorFlag=true;
    this.userFlag=false;
    this.removeTechnologyFlag=false;
  this.addTechnologyFlag=false;
    this.technologyFlag=false;
    this.removeUserFlag=false;
    this.removeMentorFlag=false;
    this.getAllMentor();
  };

  getAllMentor(): void {
    this.admindashService.getMentors()
      .subscribe( data => {
        this.mentors = data;
      })
      
  }; */

  getAllTraining(): void {
    this.trainingService.getTraining().subscribe( data =>{
      this.trainings = data; 
    });
      
  };

 /*  deleteUser(user: User): void {
    this.admindashService.deleteUser(this.users)
      .subscribe( data => {
        alert("Deleted Entry ");
        this.removeUser();
      })
  };

  deleteMentor(mentor: Mentor): void {
    this.admindashService.deleteMentor(this.mentors)
      .subscribe( data => {
        alert("Deleted Entry ");
        this.removeMentor();
      })
  };

  deleteTechnology(technology: Technology): void {
    this.admindashService.deleteTechnology(this.technology)
      .subscribe( data => {
        alert("Deleted Entry ");
        this.removeTechnology();
      })
      
  };
*/
  createTraining(): void {
    
        this.trainingService.createTraining(this.addTraining)
        .subscribe( data => {
          alert("Training created successfully.");
        });
    };
}


