import { Mentor } from "./mentor.model";
import { Technology } from "./technology.model";
import { Skill } from "./skill.model";
import { User } from "./user.model";


export class Training
{
  trainingId:number;
  mentorId:number;
  technologyId:number;
  progress:number;
  CommissionAmount:number;
  rating:number;
  avgrating:number;
  startDate:String;
  endDate:String;
  startTime:String;
  endTime:String;
  amtReceived:number;
  mentor:Mentor=new Mentor();
  technology:Technology=new Technology();
  skill:Skill[];
  user:User[];
  users:User;
}
