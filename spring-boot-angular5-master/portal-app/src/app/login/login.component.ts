import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Mlogin } from '../models/mlogin.model';
import { User } from '../models/user.model';

import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: []
})
export class LoginComponent{

  user: User=new User();

  constructor(private router: Router, private loginService: LoginService) {

  }

  Validate(): void {
    this.loginService.Validate(this.user)
      .subscribe( data => {
        if(data==null)
        {
          alert("Enter correct userName or password");
        }
        else if( data.active=="false")
        {
          alert("You are blocked");
        }
        else 
        {
          this.router.navigate(['learndash']);
          localStorage.setItem('userData',JSON.stringify(data));
        }
      })
  };

}


