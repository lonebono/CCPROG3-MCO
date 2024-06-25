import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    Scanner sc = new Scanner(System.in);

    private int roomName;
    private double pricePerNight = 1299.0;;
    private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
    /*private final String[] months = {"January", "February", "March", "April", "May", "June",
                                "July", "August", "September", "October", "November", "December"};*/
    private boolean availRoom;
    
    public Room(int roomName){
        this.roomName = roomName;
    }

    public void bookReserve() {
        
        System.out.println("Enter your name: ");
        String guestName = sc.nextLine();

        int inDay, outDay;
        do {   
            do { 
                System.out.println("Enter Book-In Day:");
                inDay = sc.nextInt();

                if(inDay >= 31 || inDay < 1) {
                    System.out.println("Invalid day. Please enter a valid day (1-30)");
                }
            }  while (inDay >= 31 || inDay < 1); //Check-In cannot be in the 31st of the month and out of bounds

            do { 
                System.out.println("Enter Book-Out Day:");
                outDay = sc.nextInt();

                if(outDay <= 1 || outDay > 31) {
                    System.out.println("Invalid day. Please enter a valid day (2-31)");
                }
            } while (outDay <= 1 || outDay > 31); //Check-Out cannot be in the 1st of the month and out of bounds

        } while (inDay > outDay);
        
        /*int inMonth = 0;
        do { 
            System.out.println("Enter Book-In Month:");
            String strInMonth = sc.nextLine();
        
            for(int i = 0; i < 12; i++){
                if(months[i].equalsIgnoreCase(strInMonth)) {
                  inMonth = i;
                }
                else inMonth = 0;
            }
        } while(inMonth < 1 || inMonth > 12); //Repeats until a valid month
        

        int inDay;
        do { 
            System.out.println("Enter Book-In Day:");
            inDay = sc.nextInt();
        } while (inDay == 31); //Check-In cannot be  in the 31st of the month
        
        //block inputs lower than year 2000?
        System.out.println("Enter Book-In Year:");
        int inYear = sc.nextInt();

        this.inDate = new Date(inMonth, inDay, inYear); //compare to other reservations unfinished

        int outMonth = 0;
        do { 
            System.out.println("Enter Book-Out Month:");
            String strOutMonth = sc.nextLine();
        
            for(int i = 0; i < 12; i++){
                if(months[i].equalsIgnoreCase(strOutMonth)) {
                  outMonth = i;
                }
                else outMonth = 0;
            }
        } while(outMonth < 1 || outMonth > 12); //Repeats until a valid month

        int outDay;
        do { 
            System.out.println("Enter Book-Out Day:");
            outDay = sc.nextInt();
        } while (outDay == 1); //Check-Out cannot be  in the 1st of the month
        
        //block inputs lower than year 2000?
        System.out.println("Enter Book-Out Year:");
        int outYear = sc.nextInt();

        this.outDate = new Date(outMonth, outDay, outYear); //compare to other reservations unfinished*/

        boolean success = true;
        for(int i = 0; i < reservationList.size(); i++) {
            if(!(reservationList.get(i).canBook(inDay, outDay))) { //if an existing reservation is booked
                success = false;
            }
        }

        if(success) { //create reservation
            Reservation reserve = new Reservation(guestName, inDay, outDay, this);
            reservationList.add(reserve);
        }
    }

    public void setPrice(double newPrice) {
        this.pricePerNight = newPrice;
    }

    public int getRoomName() {
        return roomName;
    }

    public double getCost() { // may or may not be in Hotel.java
       return pricePerNight;
    }

    public boolean getAvail() {
        return availRoom;
    }

    public ArrayList<Reservation> getReservationList() {
        return reservationList;
    }
}