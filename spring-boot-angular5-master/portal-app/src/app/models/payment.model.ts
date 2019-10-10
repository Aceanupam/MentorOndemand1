
import { User } from "./user.model";


export class Payment
{
  userId:number;
  trainingId:number;
  paymentId:number;
  txtType:String;
  Amount:String;
  remarks:String;
  mentorName:String;
  skillName:String;
  totalAmountToMentor:String;
  user: User=new User();

}
