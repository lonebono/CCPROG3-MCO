package MCO2.src;

import java.util.ArrayList;

public class ReserveSystem {
    private ArrayList<Hotel> hotelList = new ArrayList<>();

    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }

    /**
     * Adds a new hotel to the system.
     */
    public void addHotel(String inputHotelName) {
        String hotelName = inputHotelName;
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                return;
            }
        }
        hotelList.add(new Hotel(hotelName));
    }

    /**
     * Displays information about hotels in the system.
     * Allows viewing details like available rooms, bookings, and reservations.
     */
    public void viewHotel(String hotelName) {
        Hotel selectedHotel = getHotel(hotelName);
        if (selectedHotel != null) {
            System.out.println("\nHotel: " + selectedHotel.getHotelName());
            System.out.println("Number of rooms: " + selectedHotel.getRoomList().size());
            System.out.println("Estimated earnings for the month: " + selectedHotel.calculateTotalEarnings());
        }
    }

    /**
     * Manages operations for a specific hotel in the system.
     * Allows adding rooms, updating prices, canceling reservations, and more.
     */
    public void manageHotel(String hotelName) {
        Hotel selectedHotel = getHotel(hotelName);
        if (selectedHotel != null) {
            
        }
    }

    /**
     * Books a reservation in a selected hotel for specified check-in and check-out dates.
     */
    public void bookReserve(String hotelName, int inDay, int outDay, String guestName, int roomChoice, String discountCode) {
        Hotel selectedHotel = getHotel(hotelName);
        if (selectedHotel != null) {
            selectedHotel.bookReserve(inDay, outDay, guestName, roomChoice, discountCode);
        } else {
            System.out.println("Hotel not found.");
        }
    }

    public Hotel getHotel(String hotelName) {
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equals(hotelName)) {
                return hotel;
            }
        }
        return null;
    }
}