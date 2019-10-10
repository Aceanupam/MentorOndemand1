import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';


import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { LoginComponent } from './login/login.component';
import { MloginComponent } from './mlogin/mlogin.component';
import { MsignupComponent } from './msignup/msignup.component';
import { UsignupComponent } from './usignup/usignup.component';
import { UtrainingComponent } from './utraining/utraining.component';
import { MtrainingComponent } from './mtraining/mtraining.component';
import { HomeComponent } from './home/home.component';
import { PaymentComponent } from './payment/payment.component';
import { LearndashComponent } from './learndash/learndash.component';
import { AdmindashComponent } from './admindash/admindash.component';
import { TrainingComponent } from './training/training.component';
import { TechnologyComponent } from './technology/technology.component';


import { AppRoutingModule } from './app.routing.module';
import { UserService } from './user/user.service';
import { LoginService}  from './login/login.service';
import { AdminloginService } from './adminlogin/adminlogin.service';
import { MloginService } from './mlogin/mlogin.service';
import { MsignupService } from './msignup/msignup.service';
import { UsignupService} from './usignup/usignup.service';
import {UtrainingService} from './utraining/utraining.service';
import {MtrainingService} from './mtraining/mtraining.service';
import {LearndashService} from './learndash/learndash.service';
import {AdmindashService} from './admindash/admindash.service';
import {HomeService} from './home/home.service';
import {PaymentService} from './payment/payment.service';
import {TechnologyService} from './technology/technology.service';
import {TrainingService} from './training/training.service';



import {HttpClientModule} from "@angular/common/http";
import {AddUserComponent} from './user/add-user.component';
import {AddMsignupComponent} from './msignup/add-msignup.component';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AddUserComponent,
    AddMsignupComponent,
    LoginComponent,
    TrainingComponent,
    AdminloginComponent,
    MloginComponent,
    MsignupComponent,
    UsignupComponent,
    UtrainingComponent,
    MtrainingComponent,
    LearndashComponent,
    HomeComponent,
    PaymentComponent,
    AdmindashComponent,
    TechnologyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [AdmindashService,TrainingService,TechnologyService,AdminloginService,UserService,LoginService,MloginService,MsignupService,UsignupService,UtrainingService,HomeService,MtrainingService,PaymentService,LearndashService],
  bootstrap: [AppComponent]
})
export class AppModule { }
