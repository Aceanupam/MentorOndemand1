import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { UsignupService } from './usignup.service';

@Component({
  selector: 'app-usignup',
  templateUrl: './usignup.component.html',
  styles: []
})
export class UsignupComponent implements OnInit {

  users: User[];

  constructor(private router: Router, private usignupService: UsignupService) {

  }

  ngOnInit() {
    this.usignupService.getUsers()
      .subscribe( data => {
        this.users = data;
      });
  };

  deleteUser(user: User): void {
    this.usignupService.deleteUser(user)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
      })
  };

}


