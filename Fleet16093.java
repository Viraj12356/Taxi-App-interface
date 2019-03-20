package iiitb.ess201a7.r16093;
import java.util.ArrayList;

import iiitb.ess201a7.a7base.*;

public class Fleet16093 extends Fleet {

 private ArrayList<Car > list1=new ArrayList<Car>();
 public int value,k,l;
 public Fleet16093(int fid,String colour) {

   super(fid,colour);
 }

 @Override
 public void addCar(int id,int speed) {
  Car c=new Car16093(id,speed);
  list1.add(c);

 }

 @Override
 public Car findNearestCar(Location loc) {
  int car_i=0,count=0;
  double time=0,min_time=0;
  Car temp;
  for(int i=0;i<list1.size();i++)
  {
   temp= list1.get(i);
   
   if(temp.getStatus()==1)
   {
     time=temp.distSqrd(loc)/temp.getSpeed();
     if(count==0)
   {
     
     min_time=time;
     count=1;
     car_i=i;
   }
   else if(count!=0 && min_time>=time)
   {
     
     min_time=time;
       car_i=i;
  }

 }
  }
 return list1.get(car_i);
 }
 @Override
 public ArrayList<Car> getCars()
 {
    return list1;
}
}
