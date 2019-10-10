import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Mentor } from '../models/mentor.model';
import { MsignupService } from './msignup.service';

@Component({
  selector: 'app-msignup',
  templateUrl: './msignup.component.html',
  styles: []
})
export class MsignupComponent implements OnInit {

  mentors: Mentor[];

  constructor(private router: Router, private msignupService: MsignupService) {

  }

  ngOnInit() {
    this.msignupService.getMentors()
      .subscribe( data => {
        this.mentors = data;
      });
  };

  deleteMentor(mentor: Mentor): void {
    this.msignupService.deleteMentor(mentor)
      .subscribe( data => {
        this.mentors = this.mentors.filter(u => u !== mentor);
      })
  };

}


