import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    Scanner sc = new Scanner(System.in);

    private String hotelName;
    private ArrayList<Room> roomList = new ArrayList<Room>();
    private double estMonthEarn;

    public Hotel(String hotelName){
        this.hotelName = hotelName;
        //call create room since room minimum is 1
    }

    public void createRoom() {
        //int size = roomList.size();
        //if(size < 50) {
        //    Room room = new Room(size+1);
        //    roomList.add(room);
        //    System.out.println("Created Room Number " + (size+1));
        //}
        if(roomList.size() < 50){
            roomList.add(new Room(roomList.size() + 1));
            System.out.println("Created Room Number " + (roomList.size() + 1));
        }
    }

    public void bookRoom() {

        int num;
        do { 
            System.out.println("Enter Room Number to Book:");
            num = sc.nextInt();

            if(num < 1 || num > roomList.size()) { //if room number does not exist
                System.out.println("Room Number does not exist");
            }
            else if(!(roomList.get(num).getAvail())) { //room unavailable
                System.out.println("Room unavailable");
            }
        } while (!(roomList.get(num).getAvail()) || (num < 1 || num > roomList.size())); //does not exist or unavailable
        
        roomList.get(num).bookReserve();
        
    }

    public void setPrice(double price) {
        System.out.println("Input New price");
        double newPrice = sc.nextDouble();

        if(newPrice >= 100){
            for(int i = 0; i < roomList.size(); i++){
                roomList.get(i).setPrice(newPrice);
            }
        }
        else{System.out.println("New price must be greater or equal to 100");
        }
    }

    public String getHotelName() {
        return hotelName;
    }

    public ArrayList<Room> getRoomList(){
        return roomList;
    }

    public double getEstMonthEarn() {
        return estMonthEarn;
    }

}