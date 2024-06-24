import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    Scanner sc = new Scanner(System.in);

    private String roomName;
    private double pricePerNight;
    private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
    private ArrayList<Room> roomList = new ArrayList<Room>();
    private boolean availRoom;
    
    public Room(String roomName, double pricePerNight, boolean availRoom, ArrayList reservationList){
        this.roomName = roomName;
        this.pricePerNight = 1299.0;
        this.availRoom = availRoom;
        this.reservationList = reservationList;
    }
    
    public void createRoom(){
        roomList.add(new Room(roomName, pricePerNight, availRoom, reservationList));
    }

    public void setPrice(double price) {
        double newPrice = sc.nextDouble();

        if(newPrice >= 100){
            this.pricePerNight = newPrice;
        }
        else{System.out.println("New price must be greater or equal to 100");
        }
    }

    public String getRoomName() {
        return roomName;
    }

    //public double getCost() { // may or may not be in Hotel.java
     //   return PerNight;
    //}

    public boolean getAvail() {
        return availRoom;
    }
}