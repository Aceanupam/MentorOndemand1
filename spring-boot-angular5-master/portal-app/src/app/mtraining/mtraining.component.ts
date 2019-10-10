import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Mentor } from '../models/mentor.model';
import { User } from '../models/user.model';
import { Skill } from '../models/skill.model';
import { Training } from '../models/training.model';
import { Technology } from '../models/technology.model';
import { MtrainingService } from './mtraining.service';

import { AdmindashService } from '../admindash/admindash.service';
import { TechnologyService } from '../technology/technology.service';

@Component({
  selector: 'app-mtraining',
  templateUrl: './mtraining.component.html',
  styles: []
})
export class MtrainingComponent implements OnInit {

  users: User[];
  addTraining:Training=new Training();
  addTrainingFlag=false;
  mentorFlag=false;
  trainingListFlag=false;
  removeTrainingFlag=false;
  technologyList:Technology[];
  skillList:Skill[];
  trainingList:Training[];
  removeTraining:Training=new Training();
  

  mentorData:Mentor=new Mentor();
  constructor(private router: Router, private admindashService: AdmindashService, private mtrainingService: MtrainingService, private technologyService: TechnologyService ) {

  }

  ngOnInit() {
    /* this.mtrainingService.getUsers()
      .subscribe( data => {
        this.users = data;
      }); */
      
  
      this.mentorFlag=true;
      this.addTrainingFlag=false;    
  this.trainingListFlag=false;
  this.removeTrainingFlag=false;

      var mentorData = JSON.parse(localStorage.getItem('mentorData'));
      this.mentorData=mentorData;
      console.log(this.mentorData);
      this.addTraining.mentorId=mentorData.mentorId;
      this.addTraining.mentor.mentorId=mentorData.mentorId;
      document.getElementById("MentorName").innerHTML=mentorData.name;
  };

  removeTrainingMethod()
  {
    this.mentorList();
    this.mentorFlag=false;
      this.addTrainingFlag=false;    
  this.trainingListFlag=true;
  this.removeTrainingFlag=true;
  
  }


  addTrainingMethod()
  {
    this.getAllSkill();
    this.getAllTechnology();
    this.addTrainingFlag=true;
    this.mentorFlag=false;
    this.trainingListFlag=false;
    this.removeTrainingFlag=false;

  
  }

  deleteTraining(): void {
    this.mtrainingService.deleteTraining(this.removeTraining)
      .subscribe( data => {
        alert("Deleted Entry");
        this.removeTrainingMethod();
      })
  }; 

  getAllTechnology(): void {
    this.technologyService.getTechnology().subscribe( data =>{
      this.technologyList = data; 
    });
      
  };

  getAllSkill(): void {
    this.admindashService.getSkills().subscribe( data =>{
      this.skillList = data;
      this.addTraining.skill=this.skillList; 
    });
      
  };

  createTraining()
{  
  console.log(this.addTraining);
  this.mtrainingService.createTraining(this.addTraining)
        .subscribe( data => {
          alert("Training created successfully.");
        });
  };

  mentorList(){
    this.trainingListFlag=true;
    this.removeTrainingFlag=false;
 this.addTrainingFlag=false;
    this.mentorFlag=false;
    this.mtrainingService.getTrainingList(this.addTraining.mentorId)
        .subscribe( data => {
          this.trainingList=data;
        });
  }

}


