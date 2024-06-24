import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    Scanner sc = new Scanner(System.in);

    private String hotelName;
    private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    private ArrayList<Room> roomList = new ArrayList<Room>();
    private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
    private double estMonthEarn;

    public Hotel(String hotelName, ArrayList roomList, ArrayList reservationList){
        this.hotelName = hotelName;
        this.roomList = roomList;
        this.reservationList = reservationList;
    }

    public void createHotel(){
        hotelList.add(new Hotel(hotelName, roomList, reservationList));
    }

    public void deleteHotel(){
        System.out.println("Enter Hotel Name to be Deleted:");
        String del = sc.nextLine();

        for(int i = 0; i < hotelList.size(); i++){
            if(!(hotelList.get(i).hotelName.equalsIgnoreCase(del))){ // cannot be the same word HOTEL = hotel
                hotelList.remove(i);
            }
        } 
    }

    public void setHotelName(){
        System.out.println("Enter New Hotel Name:");
        String name = sc.nextLine();

        for(int i = 0; i < hotelList.size(); i++){
            if(!(hotelList.get(i).hotelName.equalsIgnoreCase(name))){ // cannot be the same word HOTEL = hotel
                this.hotelName = name;
            }
        }
    }

}