import java.util.ArrayList;
import java.util.Scanner;


public class Room {
    Scanner sc = new Scanner(System.in);


    private int roomName;
    private double pricePerNight = 1299.0;;
    private ArrayList<int> availability = new ArrayList<int>();
   
    public Room(int roomName){
        this.roomName = roomName;
	for(int i = 1; i <= 31; i++) {
	availability.add(i); //need this.??
	}
    }


    public void setPrice(double newPrice) {
        this.pricePerNight = newPrice;
    }


    public int getRoomName() {
        return roomName;
    }


    public double getCost() { 
       return pricePerNight;
    }


    public boolean getAvail() {
        return availRoom;
    }


    public double getPricePerNight(){
	return pricePerNight;
    }


    public ArrayList<int> getAvail() { //month availability
          return availability;
     }


     public Boolean roomCheck(ArrayList<int> occDays) { 
         boolean result = true;
         for(int i = 0; i < occDays.size(); i++) {
            if(!availability.contains(occDays.get(i))) { //if a day is not available      result = false;
            }
        }
        return result;
    }






    public void changeAvail(int in, int out) { //new booked days
        for(i = 0; i < availability.size(); i++) {
		if(availability.get(i) >= in && availability.get(i) < out) {
			availability.remove(i);
		}
	}
    }


}
