import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { PaymentService } from './payment.service';

@Component({
  templateUrl: './add-user.component.html'
})
export class AddUserComponent {

  user: User = new User();

  constructor(private router: Router, private paymentService: PaymentService) {

  }

  createUser(): void {
    this.paymentService.createUser(this.user)
        .subscribe( data => {
          alert("User created successfully.");
        });

  };

}
