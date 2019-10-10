import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/user.model';
import { Payment } from '../models/payment.model';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class PaymentService {

  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8090/user';
  private paymentUrl = 'http://localhost:8090/payments';

  //private userUrl = '/api';

  public getUsers() {
    return this.http.get<User[]>(this.userUrl);
  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + "/"+ user.id);
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }

  public createPayment(payment) {
    return this.http.post<Payment>(this.paymentUrl, payment);
  }

}
