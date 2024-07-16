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
	    System.out.println("Hotel has been added");
        }
        else{
            System.out.println("Enter New Hotel Name:");
            String name = sc.nextLine();
            for(int i = 0; i < hotelList.size(); i++){
                if(!(hotelList.get(i).getHotelName().equalsIgnoreCase(name))){ // cannot be the same word HOTEL = hotel
                    Hotel hotel = new Hotel(name);
                    hotelList.add(hotel);
		     System.out.println("Hotel has been added");
                }
            }
        }
    }
   
    public void deleteHotel(){
      	System.out.println("Enter Hotel Name to be Deleted:");
	System.out.println("Enter Quit to exit");
	System.out.println("Enter ""Yes"" to confirm.");
       	String del = sc.nextLine();
String confirm = sc.nextLine();
	if(!(del.equals("Quit")){
        	for(int i = 0; i < hotelList.size(); i++){
            		if(!(hotelList.get(i).getHotelName().equalsIgnoreCase(del))){
if(hotelList.get(i).reservationList.size() > 0){
System.out.println("Enter ""Yes"" to confirm.");
System.out.println("This hotel has current reservations.");
if(confirm.equals("Yes"))
hotelList.remove(i);
				}
				else
					hotelList.remove(i);
            		}
        	}
		System.out.println("Hotel has been deleted");
	}
    }
    //manage hotel // NEED TO DO THIS
    public void manageHotel(){ 
	System.out.println("Pick a Hotel: ");
        String manageHotelChoice = sc.nextLine();
        for(int i = 0; i < hotelList.size(); i++){
            System.out.println("[" + (i+1) + "]" + hotelList.get(i).getHotelName());
        }
	// while not a valid hotel choice?
	 for(int i = 0; i < hotelList.size(); i++){
            if(hotelList.get(i).getHotelName().equals(manageHotelChoice)){
		// manages the chosen hotel
		int manageChoice = sc.nextInt();
		while(manageChoice != ){
		System.out.println("Menu:");
		System.out.println("[1] Change Hotel");
System.out.println("[2] Add Room");
System.out.println("[3] Remove Room");
System.out.println("[4] Set New Room Price");
System.out.println("[5] Remove Reservation");
System.out.println("[6] Remove Hotel");
		}
	}
	
    }


    //view hotel 
    public void viewHotel(){
        System.out.println("Pick a Hotel: ");
        String hotelChoice = sc.nextLine();
        for(int i = 0; i < hotelList.size(); i++){
            System.out.println("[" + (i+1) + "]" + hotelList.get(i).getHotelName());
        }
       
        for(int i = 0; i < hotelList.size(); i++){
            if(hotelList.get(i).getHotelName().equals(hotelChoice)){
                int infoChoice = sc.nextInt();
                while(infoChoice != 4){
                infoChoice = sc.nextInt();
                System.out.println("Main Information: ");
                System.out.println("Hotel Name: " + hotelList.get(i).getHotelName());
                System.out.println("Number of Rooms: " + hotelList.get(i).getRoomList().size());
                System.out.println("Estimated Monthly Earnings: " + hotelList.get(i).getEstMonthEarn());
                System.out.println("Other Information: ");
                System.out.println("[1] Room Availability ");
                System.out.println("[2] Room Information ");
                System.out.println("[3] Reservation Information ");
                System.out.println("[4] Quit");
                    if(infoChoice == 1){ // total number of avail and booked rooms
			int dayChoice;
			for(int j = 0; j < hotelList.get(i).roomList.size(); j++){
				
			}
				  
  //} may be a wrong } 
                    }
                    else if (infoChoice == 2){
                        System.out.println("Pick a room. ");
			  String roomViewChoice;
			  roomviewChoice = sc.nextLine();
                        for(int j = 0; j < hotelList.get(i).roomList.size(); j++){
				System.out.println("Room " + hotelList.get(i).getRoomList.get(j).getRoomName());
			  }
			  for(int j = 0; j < hotelList.get(i).roomList.size(); j++){
			if(roomViewChoice.equals(hotelList.get(i).roomList.get(j).getRoomName())){
				System.out.println("Room: " + hotelList.get(i).getRoomList.get(j).getRoomName());
				System.out.println("Price: " + hotelList.get(i).getRoomList.get(j).getCost());
				System.out.println("Availablity Days: " + hotelList.get(i).getRoomList.get(j).getAvail());
				}
			  }	
                    }
                    else if (infoChoice == 3){
                        int reservationChoice; //checks reservation name and prints info
                        reservationChoice = sc.nextLine();
                        System.out.println("Reservation Names: ");
			  for(int j = 0; j < hotelList.get(i).reservationList.size(); j++){
				System.out.println("Guest Name: " + hotelList.get(i).getReservationList.get(j).getGuestName());
  }
  for(int j = 0; j < hotelList.get(i).reservationList.size(); j++){
				if(reservationChoice.equals(hotelList.get(i).getReservationList.get(j).getGuestName())){
					System.out.println("Guest Name: " + hotelList.get(i).getReservationList.get(j).getGuestName());
					System.out.println("Room Name: " + hotelList.get(i).getReservationList.get(j).roomInfo.getRoomName());
					System.out.println("Price: " + hotelList.get(i).getReservationList.get(j).roomInfo.getCost());
					System.out.println("In Day: " + hotelList.get(i).getReservationList.get(j).getInDay());
					System.out.println("Out Day: " + hotelList.get(i).getReservationList.get(j).getOutDay());
					System.out.println("Booking Price: " + hotelList.get(i).getReservationList.get(j).calculateBookPrice());
					int totalDays = (hotelList.get(i).getReservationList.get(j).getOutDay()) - (hotelList.get(i).getReservationList.get(j).getInDay())
					System.out.println("Day Breakdown: ")
					for(int u = 0; u < totalDays; u++){
					System.out.println("Day " + (u+1) + " = " + hotelList.get(i).getReservationList.get(j).roomInfo.getCost());
}
				}
  }                                     
                
}
            }
        }
    }


}
