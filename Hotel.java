import java.util.ArrayList;
import java.util.Scanner;


public class Hotel {
    Scanner sc = new Scanner(System.in);


    private String hotelName;
    private ArrayList<Room> roomList = new ArrayList<Room>();
    private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
    private double estMonthEarn;


    public Hotel(String hotelName){
        this.hotelName = hotelName;
	this.roomList = new ArrayList<>;
	this.reservationList = new ArrayList<>;
        createRoom(); //call create room since room minimum is 1
    }


    public void createRoom() {
        if(roomList.size() < 50 && roomList.size() >= 0){
            roomList.add(new Room(roomList.size() + 1));
            System.out.println("Created Room Number " + (roomList.size() + 1));
        }
    }


    public void removeRoom(){
        // can remove if no reservation
	int roomChoice;
	System.out.println("Rooms that can be removed:");


	for(int i = 0; i < roomList.size(); i++){
if(roomList.get(i).reservationList.size() == 0){
		System.out.println(i);
	}
    }
//do {
System.out.println(“Remove Room: “)
roomChoice = sc.nextInt();


if(roomChoice > roomList.size() || roomChoice < 0) {
System.out.println(“Room ” + roomChoice + “ does not exist“);
}else if(roomList.get(roomChoice - 1).reservationList.size() != 0) {
System.out.println(“Room ” + roomChoice + “ cannot be removed“);
}
else System.out.println(“Confirm Removal of Room “ + roomChoice + “YES[1] NO[Any Other Number]”);
int yesNo = sc.nextInt;


if(yesNo == 1) {
roomList.remove(roomChoice - 1);
}
}
    public void setPrice(double price) {
boolean success = true;
for(int i = 0; i < roomList.size(); i++){
if(roomList.get(i).reservationList.size() != 0){
success = false
}
}
if(success){
do {
        System.out.println("Input New price");
        double newPrice = sc.nextDouble();


        if(newPrice >= 100){
            for(int i = 0; i < roomList.size(); i++){
                roomList.get(i).setPrice(newPrice);
            }
	System.out.println("Price has been updated!");
        }
        else{System.out.println("New price must be greater or equal to 100");
        }
} while(newPrice < 100);
    }
    else System.out.println("An existing reservation exists. Cannot change price.");
}
    public String getHotelName() {
        return hotelName;
    }


    public ArrayList<Room> getRoomList(){
        return roomList;
    }


    public ArrayList<Reservation> getReservationList(){
	return reservationList;
    }


    public double getEstMonthEarn() {
	double estimate = 0;
		for(int j = 0; j < roomList().get(i).getReservationList().size(); j++){
			estimate += reservationList().get(j).calculateBookPrice();
}
        	return estimate;
    }


public void removeReserve() {
System.out.println("Enter saved reservation’s Guest Name: ");
String name = sc.nextLine();


boolean exist = false;
int reserveIndex;
for(int i = 0; i < reservationList.size(); i++){
if(reservationList.get(i).guestName.equalsIgnoreCaps(name)){
exist = true;
int reserveIndex = i;
}


if(exist) {
System.out.println(“Confirm Removal of Reservation under “ + name + “YES[1] NO[Any Other Number]”);
int yesNo = sc.nextInt;


if(yesNo == 1) {
reservationList.remove(reserveIndex);
}
}
else System.out.println("Reservation does not exist");
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


        if(inDay > outDay) {
           System.out.println("Invalid Booking Dates. Check-out day cannot equal or exceed Check-in date");
        }


        } while (inDay >= outDay);


  ArrayList<int> occ = computeOcc(inDay, outDay);
  boolean success = false;
	if(countAvail(occ) > 0) {
	success = true;
	}


        if(success) { //create reservation
	Room roomAvail = bookRoom(occ);
            Reservation reserve = new Reservation(guestName, inDay, outDay, roomAvail);
            reservationList.add(reserve);
        }
        else System.out.println("There are no available rooms for that date. Please create another booking");
    }


public ArrayList<int> computeOcc(int in, int out) {
ArrayList<int> occDays = new ArrayList<int>(); //days occupied
     for(int i = in; i < out; i++) {
        occDays.add(i); //add this. ??
       }
return occDays;
}


public void countAvailBook(ArrayList<int> occ) {
int cAvail = countAvail(occ);
int cBook = countBook(occ);


System.out.println("There are “ + cAvail + “ Available room/s for the selected date”);


System.out.println("There are “ + cBook + “ Booked room/s for the selected date”);
}




public int countAvail(ArrayList<int> occ) {
int avail = 0;


    for(int i = 0; i < roomList.size(); i++) {
	if(roomList.get(i).roomCheck(occ)) {
	avail++;
	}
     }
return avail;
}


public int countBook(ArrayList<int> occ) {
int book = 0;


    for(int i = 0; i < roomList.size(); i++) {
	if(!(roomList.get(i).roomCheck(occ))) {
	book++;
	}
     }
return book;
}


public Room bookRoom(ArrayList<int> occ) {
for(int i = 0; i < roomList.size(); i++) {
	if(roomList.get(i).roomCheck(occ)) {
	return roomList.get(i);
	}
}
