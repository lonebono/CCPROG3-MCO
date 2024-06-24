import java.util.ArrayList;
import java.util.Scanner;

public class ReserveSystem {

    private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    
    Scanner sc = new Scanner(System.in);

    public void addHotel(){
        if(hotelList.size() < 1){ // when there are no hotels
            System.out.println("Enter Hotel Name:");
            String name = sc.nextLine();
            Hotel hotel = new Hotel(name);
            hotelList.add(hotel);
        }
        else{
            System.out.println("Enter New Hotel Name:");
            String name = sc.nextLine();

            for(int i = 0; i < hotelList.size(); i++){
                if(!(hotelList.get(i).getHotelName().equalsIgnoreCase(name))){ // cannot be the same word HOTEL = hotel
                    Hotel hotel = new Hotel(name);
                    hotelList.add(hotel);
                }
            }
        }
    }
    
    // need to check if rooms are unoccupied
    public void deleteHotel(){
        System.out.println("Enter Hotel Name to be Deleted:");
        String del = sc.nextLine();

        for(int i = 0; i < hotelList.size(); i++){
            if(!(hotelList.get(i).getHotelName().equalsIgnoreCase(del))){ // cannot be the same word HOTEL = hotel
                hotelList.remove(i);
            }
        } 
    }
    
    //view hotel
    public void viewHotel(){
        System.out.println("Pick a Hotel: ");
        String hotelChoice = sc.nextLine();
        for(int i = 0; i < hotelList.size(); i++){
            System.err.println("[" + (i+1) + "]" + hotelList.get(i).getHotelName());
        }
        
        for(int i = 0; i < hotelList.size(); i++){
            if(hotelList.get(i).getHotelName().equals(hotelChoice)){
                //while( ){

                //}
                int infoChoice = sc.nextInt();
                System.out.println("Main Information: ");
                System.out.println("Hotel Name: " + hotelList.get(i).getHotelName());
                System.out.println("Number of Rooms: " + hotelList.get(i).getRoomList().size());
                //System.out.println("Estimated Monthly Earnings: " + hotelList.get(i).getEstMonthEarn());
                System.err.println(""); // 
            }
        }
    }

}