import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { Technology } from '../models/technology.model';
import { Mentor } from '../models/mentor.model';
import { TechnologyService } from './technology.service';

@Component({
  selector: 'app-technology',
  templateUrl: './technology.component.html',
  styles: []
})
export class TechnologyComponent //implements OnInit 
{

  users: User[];
  mentors:Mentor[];
  technology:Technology[];
  addTechnology:Technology=new Technology();
  userFlag=false;
  technologyFlag=false;
  removeTechnologyFlag=false;
  addTechnologyFlag=false;
  mentorFlag=false;
  removeUserFlag=false;
  removeMentorFlag=false;
  constructor(private router: Router, private technologyService: TechnologyService) {

  }

  /* ngOnInit() {
    this.admindashService.getUsers()
      .subscribe( data => {
        this.users = data;
      });
  }; */
/* 
  addNewTechnology(): void{
  this.userFlag=false;
  this.technologyFlag=false;
  this.removeTechnologyFlag=false;
  this.addTechnologyFlag=true;
  this.mentorFlag=false;
  this.removeUserFlag=false;
  this.removeMentorFlag=false;

  }
*/
  technologyList(): void{
    this.getAllTechnology();
    this.userFlag=false;
  this.technologyFlag=true;
  this.removeTechnologyFlag=false;
  this.addTechnologyFlag=false;
  this.mentorFlag=false;
  this.removeUserFlag=false;
  this.removeMentorFlag=false;
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

  getAllTechnology(): void {
    this.technologyService.getTechnology().subscribe( data =>{
      this.technology = data; 
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

  createTechnology(): void {
    
    this.admindashService.check(this.addTechnology.techName).subscribe( data =>{
      if(data==true)
      {
        
        this.admindashService.createTechnology(this.addTechnology)
        .subscribe( data => {
          alert("Technology created successfully.");
        });

      }
      else
      {
        alert("Technology already exists");
      }

    })
  };
 */
}


