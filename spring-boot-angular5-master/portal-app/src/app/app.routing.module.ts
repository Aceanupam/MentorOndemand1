import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './user/user.component';
import { MloginComponent } from './mlogin/mlogin.component';
import { AddMsignupComponent } from './msignup/add-msignup.component';

import { LoginComponent } from './login/login.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { HomeComponent } from './home/home.component';
import { MsignupComponent } from './msignup/msignup.component';
import { UsignupComponent } from './usignup/usignup.component';
import { UtrainingComponent } from './utraining/utraining.component';
import { MtrainingComponent } from './mtraining/mtraining.component';
import { LearndashComponent } from './learndash/learndash.component';
import { PaymentComponent } from './payment/payment.component';
import { AdmindashComponent } from './admindash/admindash.component';
import { TechnologyComponent } from './technology/technology.component';
import { TrainingComponent } from './training/training.component';


import {AddUserComponent} from './user/add-user.component';

const routes: Routes = [
  { path:'', redirectTo: '/home',pathMatch:'full'},
  { path: 'users', component: UserComponent },
  { path: 'add', component: AddUserComponent },
  { path: 'technology', component: TechnologyComponent },
  { path: 'addmsignup', component: AddMsignupComponent },
  { path: 'training', component: TrainingComponent },

  { path: 'mlogin', component: MloginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'adminlogin', component: AdminloginComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'home', component: HomeComponent },
  { path: 'utraining', component: UtrainingComponent },
  { path: 'admindash', component: AdmindashComponent },
  { path: 'learndash', component: LearndashComponent },
  { path: 'mtraining', component: MtrainingComponent },
  { path: 'msignup', component: MsignupComponent },
  { path: 'usignup', component: UsignupComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
