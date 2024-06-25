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
                int infoChoice = sc.nextInt();
                while(infoChoice != 4){
                infoChoice = sc.nextInt();
                System.out.println("Main Information: ");
                System.out.println("Hotel Name: " + hotelList.get(i).getHotelName());
                System.out.println("Number of Rooms: " + hotelList.get(i).getRoomList().size());
                //System.out.println("Estimated Monthly Earnings: " + hotelList.get(i).getEstMonthEarn());
                System.out.println("Other Information: "); // has 3 other options plus quit
                System.out.println("[1] Room Availability ");
                System.out.println("[2] Room Information ");
                System.out.println("[3] Reservation Information ");
                System.out.println("[4] Quit");
                    if(infoChoice == 1){ // total number of avail and booked rooms
                        int dateChosen; // was = sc.nextInt()
                        dateChosen = sc.nextInt();
                        System.out.println("Enter Day (1-31): ");
                        for(int j = 0; j < hotelList.get(i).getRoomList().size(); j++){
                            hotelList.get(i).getRoomList().get(j).getReservationList(k)
                        }
                    }
                    else if (infoChoice == 2){
                        int roomChoice;
                        roomChoice = sc.nextInt(); // may have to switch to string in order to compare to room name // not sure abt this
                        System.out.println("Enter which room to view: ");
                        for(int j = 0; j < hotelList.get(i).getRoomList().size(); j++){
                            System.out.println("Room " + hotelList.get(i).getRoomList().get(j));
                        }
                        for(int j = 0; j < hotelList.get(i).getRoomList().size(); j++){
                            if((roomChoice-1) == hotelList.get(i).getRoomList().get(j).getRoomName()){
                                System.out.println("Room Name: " + hotelList.get(i).getRoomList().get(j).getRoomName());
                                System.out.println("Room Price per Night: " + hotelList.get(i).getRoomList().get(j).getCost());
                                System.out.println("Room Availability: "); // not sure how to implement availability// inDay and outDay?
                            }
                        }




                    }
                }
            }
        }
    }

}