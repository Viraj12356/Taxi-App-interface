import java.util.ArrayList;

import iiitb.ess201a7.a7base.*;

public class Platform {
private Car c;
private Location b;
private ArrayList<Fleet> list=new ArrayList<Fleet>();

// all the methods in this class need to be implemented

 public Platform() {}

 public void addFleet(Fleet f) {
  list.add(f);
 }

 // for a request defined as a Trip, find the best car by checking each of its fleets
 // and assigns the car to this trip
 public Car assignCar(Trip trip) {
  int car_i=0,id,count=0;
  double time,min_time=0;
  Car temp = null;

  for(int i=0;i<list.size();i++)
  {
   temp=list.get(i).findNearestCar(trip.getStart());
   time=temp.distSqrd(trip.getStart())/temp.getSpeed();
    if(count==0 && temp.getStatus()!=1)
   {
     min_time=time;
     count=1;
     car_i=i;
   }
   else if(count!=0 && min_time>=time && temp.getStatus()!=1)
   {
     min_time=time;
       car_i=i;
  }
  }
  if(temp!=null){
     temp = list.get(car_i).findNearestCar(trip.getStart());
     temp.assignTrip(trip);
  }
  return  temp;
 }
 // returns list of all cars (in all the fleets) managed by this platform
 public ArrayList<Car> findCars()
 {
    ArrayList<Car> Lis=new  ArrayList<Car>();

   for(Fleet i:list)
  {
   Lis.addAll(i.getCars());
 }
  return Lis;
 }
}
