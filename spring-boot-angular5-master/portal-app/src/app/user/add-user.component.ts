import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { UserService } from './user.service';

@Component({
  templateUrl: './add-user.component.html'
})
export class AddUserComponent {

  user: User = new User();

  constructor(private router: Router, private userService: UserService) {

  }

  createUser(): void {
    this.userService.check(this.user.userName).subscribe( data =>{
      if(data==true)
      {
        this.userService.createUser(this.user)
        .subscribe( data => {
          alert("User created successfully.");
        });

        this.router.navigate(['login']);
      }
      else
      {
        alert("Username already exists");
      }

    })
  };

}
