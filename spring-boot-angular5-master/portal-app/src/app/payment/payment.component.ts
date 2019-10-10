import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { Training } from '../models/training.model';
import { Payment } from '../models/payment.model';

import { PaymentService } from './payment.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styles: []
})
export class PaymentComponent implements OnInit {

  users: User[];
  addPayment: Payment=new Payment();

  constructor(private router: Router, private paymentService: PaymentService) {

  }

  ngOnInit() {
    /* this.paymentService.getUsers()
      .subscribe(data => {
        this.users = data;
      }); */
      var trainingData= JSON.parse(localStorage.getItem('trainingData'));

  };

  deleteUser(user: User): void {
    this.paymentService.deleteUser(user)
      .subscribe(data => {
        this.users = this.users.filter(u => u !== user);
      })
  };

  createPayment(){
    var trainingData=JSON.parse(localStorage.getItem('trainingData'));
    this.addPayment.trainingId=trainingData.trainingId;
    this.addPayment.userId=trainingData.user.userId;
    this.addPayment.txtType="Billable"
    this.addPayment.Amount=trainingData.CommissionAmount;
    this.addPayment.remarks="Great!!"
    this.addPayment.mentorName=trainingData.mentor.name;
    this.addPayment.skillName="More than one";
    this.addPayment.totalAmountToMentor=trainingData.CommissionAmount;

    this.paymentService.createPayment(this.addPayment)
    .subscribe(data => {
      alert("Payment created successfully");
  });
}

}


