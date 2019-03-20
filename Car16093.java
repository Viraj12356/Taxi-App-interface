package iiitb.ess201a7.r16093;
import java.lang.*;
import iiitb.ess201a7.a7base.*;

class Car16093 extends Car {
 private int status;
 private Trip t;
 private Location a,b,c;
 private int distance;
 private double dist,dist2;
 public Car16093(int fid,int speed) {
   super(fid,speed);
   status = 1;
 }
 @Override
public int distSqrd(Location loc) {

  distance=(int)(Math.pow((a.getX()-loc.getX()),2)+Math.pow((a.getY()-loc.getY()),2));
  return distance;
 }
 @Override
 public void setLocation(Location l) {
  // TODO Auto-generated method stub
  a=l;
 }

 @Override
 public Location getLocation() {
  // TODO Auto-generated method stub
  return a;
 }

 @Override
 public void setStatus(int s) {
  // TODO Auto-generated method stub
   status=s;
 }


 @Override
 public int getStatus() {
  // TODO Auto-generated method stub
  return status;
 }

 @Override
 public void assignTrip(Trip trip) {
  // TODO Auto-generated method stub
   //if(status==1){
    t=trip;
    b=t.getStart();
    c=t.getDest();
    status=2;
  //System.out.println(status);
  // }
  // else System.out.println("Car not available");
 }

 @Override
 public Location getStart() {
  // TODO Auto-generated method stub
  if(status==1)
  {
  return null;
 }
  else
  {
    return b;
  }
 }
 @Override
 public Location getDest() {
  // TODO Auto-generated method stub
   if(status==1)
  {
  return null;
 }
  else
  {
    return c;
  }
 }

 @Override
public void updateLocation(double deltaT){
   // TODO Auto-generated method stub
    dist=(maxSpeed*deltaT);
    
   if(status==2){
     dist2=Math.pow(a.getX()-b.getX(),2)+Math.pow(a.getY()-b.getY(),2);
    dist2=Math.sqrt(dist2);
    if(dist>dist2)
   {
     a.set(b.getX(),b.getY());
   }
   
    if (dist<=dist2)
   {
      
     a.set((int)((double)(b.getX()-a.getX())*(dist/dist2)+(double)a.getX()),(int)((double)(b.getY()-a.getY())*(dist/dist2)+(double)a.getY()));
   }
  
   else
   {
     status=3;
    }
   }
  else if(status==3){
   dist2=Math.pow(a.getX()-c.getX(),2)+Math.pow(a.getY()-c.getY(),2);
   dist2=Math.sqrt(dist2);
    if(dist>dist2)
   {
     a.set(c.getX(),c.getY());
   }
   if (dist<=dist2)
   { 
      a.set((int)((double)(c.getX()-a.getX())*(dist/dist2)+(double)a.getX()),(int)((double)(c.getY()-a.getY())*(dist/dist2)+(double)a.getY()));
   }
  
   else{
     status=1;
    }

 }
 }
 @Override
  public Trip getTrip()
  {
    return t;
  }
}
