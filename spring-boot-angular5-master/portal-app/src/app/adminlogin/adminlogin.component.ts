import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Admin } from '../models/admin.model';
import { AdminloginService } from './adminlogin.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styles: []
})
export class AdminloginComponent  {

  admin: Admin=new Admin();

  constructor(private router: Router, private adminloginService: AdminloginService) {

  }

  Validate(): void {
    this.adminloginService.Validate(this.admin)
      .subscribe( data => {
        if(data==null)
        {
          alert("Enter correct userName or password");
        }
        else
        {
          alert("You are in");

          this.router.navigate(['admindash']);
          localStorage.setItem('adminData',JSON.stringify(data));
        }
      })
  };


}


