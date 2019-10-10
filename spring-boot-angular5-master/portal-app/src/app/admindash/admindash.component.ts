import { Component, OnInit, ModuleWithComponentFactories } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { Skill } from '../models/skill.model';
import { Technology } from '../models/technology.model';
import { Mentor } from '../models/mentor.model';
import { AdmindashService } from './admindash.service';
import { MsignupService } from '../msignup/msignup.service';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-admindash',
  templateUrl: './admindash.component.html',
  styles: []
})
export class AdmindashComponent //implements OnInit 
{

  users: User[];
  userProfile:User=new User();
  mentors:Mentor[];
  skill:Skill[];
  mentorProfile:Mentor=new Mentor();
  mentorActive: Mentor=new Mentor();
  technology:Technology[];
  addSkill:Skill=new Skill();
  addTechnology:Technology=new Technology();
  userFlag=false;
  technologyFlag=false;
  removeTechnologyFlag=false;
  addTechnologyFlag=false;
  skillFlag=false;
  removeSkillFlag=false;
  addSkillFlag=false;
  mentorFlag=false;
  removeUserFlag=false;
  removeMentorFlag=false;
  constructor(private router: Router, private admindashService: AdmindashService, private msignupService:MsignupService, private userService:UserService) {

  }

  /* ngOnInit() {
    this.admindashService.getUsers()
      .subscribe( data => {
        this.users = data;
      });
  }; */

  changeStatus(mentor){
    alert(mentor.active);
    this.msignupService.createMentor(mentor).subscribe( data => {
      this.mentorProfile = data;
      alert("Mentor Updated");
      this.mentorList();
    });
  }

  changeUserStatus(user){
    alert(user.active);
    this.userService.createUser(user).subscribe( data => {
      this.userProfile = data;
      alert("User Updated");
      this.userList();
    });
  }

  addNewTechnology(): void{
  this.userFlag=false;
  this.technologyFlag=false;
  this.removeTechnologyFlag=false;
  this.addTechnologyFlag=true;
  this.mentorFlag=false;
  this.removeUserFlag=false;
  this.removeMentorFlag=false;
  this.skillFlag=false;
  this.removeSkillFlag=false;
  this.addSkillFlag=false;

  }

  technologyList(): void{
    this.getAllTechnology();
    this.userFlag=false;
  this.technologyFlag=true;
  this.removeTechnologyFlag=false;
  this.addTechnologyFlag=false;
  this.mentorFlag=false;
  this.removeUserFlag=false;
  this.removeMentorFlag=false;
  this.skillFlag=false;
  this.removeSkillFlag=false;
  this.addSkillFlag=false;

  }

  removeTechnology(): void {
    this.userFlag=false;
  this.technologyFlag=true;
  this.removeTechnologyFlag=true;
  this.addTechnologyFlag=false;
  this.mentorFlag=false;
  this.removeUserFlag=false;
  this.removeMentorFlag=false;
  this.skillFlag=false;
  this.removeSkillFlag=false;
  this.addSkillFlag=false;

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
    this.skillFlag=false;
  this.removeSkillFlag=false;
  this.addSkillFlag=false;

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
    this.skillFlag=false;
  this.removeSkillFlag=false;
  this.addSkillFlag=false;

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
    this.skillFlag=false;
  this.removeSkillFlag=false;
  this.addSkillFlag=false;

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
    this.skillFlag=false;
    this.removeSkillFlag=false;
    this.addSkillFlag=false;
  
    this.removeUserFlag=false;
    this.removeMentorFlag=false;
    this.getAllMentor();
  };

  getAllMentor(): void {
    this.admindashService.getMentors()
      .subscribe( data => {
        this.mentors = data;
      })
      
  };

  getAllTechnology(): void {
    this.admindashService.getTechnology().subscribe( data =>{
      this.technology = data; 
    });
      
  };

  deleteUser(user: User): void {
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

  addNewSkill(): void{
    this.userFlag=false;
    this.technologyFlag=false;
    this.removeSkillFlag=false;
    this.addSkillFlag=true;
    this.skillFlag=false;
    this.removeTechnologyFlag=false;
    this.addTechnologyFlag=false;
    this.mentorFlag=false;
    this.removeUserFlag=false;
    this.removeMentorFlag=false;
  
    }
  
    skillList(): void{
      this.getAllSkill();
      this.removeSkillFlag=false;
    this.addSkillFlag=false;
    this.skillFlag=true;
      this.userFlag=false;
    this.technologyFlag=false;
    this.removeTechnologyFlag=false;
    this.addTechnologyFlag=false;
    this.mentorFlag=false;
    this.removeUserFlag=false;
    this.removeMentorFlag=false;
    }
  
    removeSkill(): void {
      this.removeSkillFlag=true;
    this.addSkillFlag=false;
    this.skillFlag=true;
      this.userFlag=false;
    this.technologyFlag=false;
    this.removeTechnologyFlag=false;
    this.addTechnologyFlag=false;
    this.mentorFlag=false;
    this.removeUserFlag=false;
    this.removeMentorFlag=false;
      this.getAllSkill();
    };

    getAllSkill(): void {
      this.admindashService.getSkills().subscribe( data =>{
        this.skill = data; 
      });
        
    };

    deleteSkill(): void {
      this.admindashService.deleteSkill(this.addSkill)
        .subscribe( data => {
          alert("Deleted Entry ");
          this.removeSkill();
        })
    };

    createSkill() :void{
      this.admindashService.createSkill(this.addSkill)
      .subscribe( data => {
        alert("Skill created successfully.");
      });

    }

}


