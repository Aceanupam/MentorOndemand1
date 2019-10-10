import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Mentor } from '../models/mentor.model';
import { MsignupService } from './msignup.service';

@Component({
  templateUrl: './add-msignup.component.html'
})
export class AddMsignupComponent {

  mentor: Mentor = new Mentor();

  constructor(private router: Router, private msignupService: MsignupService) {

  }

  createMentor(): void {

      this.msignupService.Validate(this.mentor.userName).subscribe( data =>{
          if(data==true)
          {
            this.msignupService.createMentor(this.mentor)
            .subscribe( data => 
            {
              alert("Mentor created successfully."); 
            });
            this.router.navigate(['mlogin']);
          }
          else
          {
            alert("Username already exists");
          }
        })
      };
}
