import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Mentor } from '../models/mentor.model';
import { MloginService } from './mlogin.service';

@Component({
  selector: 'app-mlogin',
  templateUrl: './mlogin.component.html',
  styles: []
})
export class MloginComponent implements OnInit {

  mentors: Mentor[];
  mentor: Mentor=new Mentor();

  constructor(private router: Router, private MloginService: MloginService) {

  }

   ngOnInit(){
    this.MloginService.getMentor()
      .subscribe( data => {
        this.mentors = data;
      });
  }; 

  /* deleteMentor(mentor: Mentor): void {
    this.MloginService.deleteMentor(mentor)
      .subscribe( data => {
        this.mentor = this.mentor.filter(u => u !== mentor);
      })
  }; */

  Validate(): void {
    this.MloginService.Validate(this.mentor)
      .subscribe( data => {
        if(data==null)
        {
          alert("Enter correct userName or password");
        }
        else if( data.active==false)
        {
          alert("You are blocked");
        }
        else
        {
          this.router.navigate(['mtraining']);
          localStorage.setItem('mentorData',JSON.stringify(data));
        }
      })
  };

}


