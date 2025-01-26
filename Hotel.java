
package MCO2.src;
import java.util.ArrayList;

/**
 * Represents a hotel with rooms and reservations in a hotel reservation system.
 */
public class Hotel {
    private String hotelName;
    private ArrayList<Room> roomList = new ArrayList<>();
    private ArrayList<Reservation> reservationList = new ArrayList<>();
    private double basePrice = 1299.0; // starting base price


    /**
     * Constructs a hotel with a specified name.
     * Initializes with one room.
     *
     * @param hotelName The name of the hotel.
     */
    public Hotel(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Sets a new name for the hotel.
     *
     * @param newHotelName The new name to set for the hotel.
     */
    public void setHotelName(String newHotelName) {
        this.hotelName = newHotelName;
    }

    /**
     * Updates the base price of the hotel.
     * The new price must be at least $100 higher than the current base price.
     *
     * @param price The new base price to set.
     */
    public void setPrice(double price) {
        boolean success = true;
        for (Room room : roomList) {
            for (Reservation res : reservationList) {
                if (res.getRoomInfo().equals(room) && res.getOccDays().size() > 0) {
                    success = false;
                    break;
                }
            }
            if (!success) break;
        }

        if (success) {
            if (price < basePrice + 100.0) {
                System.out.println("New price must be at least $100 higher than the current price.");
                return;
            }
            basePrice = price;
            updateRoomPrices();
            System.out.println("Base price has been updated!");
        } else {
            System.out.println("An existing reservation exists. Cannot change base price.");
        }
    }

    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Retrieves the name of the hotel.
     *
     * @return The name of the hotel.
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Retrieves the list of rooms in the hotel.
     *
     * @return The list of rooms.
     */
    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    /**
     * Retrieves the list of reservations in the hotel.
     *
     * @return The list of reservations.
     */
    public ArrayList<Reservation> getReservationList() {
        return reservationList;
    }

    /**
     * Retrieves the number of available rooms in the hotel on a specified day.
     *
     * @param day The day to check availability.
     * @return The number of available rooms.
     */
    public int getAvailableRooms(int day) {
        int availableRooms = 0;
        for (Room room : roomList) {
            if (room.getAvail().contains(day)) {
                availableRooms++;
            }
        }
        return availableRooms;
    }

    /**
     * Retrieves the number of booked rooms in the hotel on a specified day.
     *
     * @param day The day to check bookings.
     * @return The number of booked rooms.
     */
    public int getBookedRooms(int day) {
        return roomList.size() - getAvailableRooms(day);
    }

    /**
     * Retrieves a room object by its room number.
     *
     * @param roomNumber The room number to retrieve.
     * @return The Room object corresponding to the room number, or null if not found.
     */
    public Room getRoom(int roomNumber) {
        if (roomNumber > 0 && roomNumber <= roomList.size()) {
            return roomList.get(roomNumber - 1);
        }
        return null;
    }

    /**
     * Retrieves a reservation object by guest name.
     *
     * @param guestName The name of the guest to retrieve reservation for.
     * @return The Reservation object corresponding to the guest name, or null if not found.
     */
    public Reservation getReservationByGuestName(String guestName) {
        for (Reservation reservation : reservationList) {
            if (reservation.getGuestName().equalsIgnoreCase(guestName)) {
                return reservation;
            }
        }
        return null;
    }

    /**
     * Creates a new room and adds it to the hotel's room list.
     * Restricts the maximum number of rooms to 50.
     */
    public void createRoom(String roomType) { 
        if (roomList.size() < 50) {
            if(roomType.equalsIgnoreCase("Standard")){
                roomList.add(new Standard(roomList.size() + 1));
            }
            if(roomType.equalsIgnoreCase("Deluxe")){
                roomList.add(new Deluxe(roomList.size() + 1));
            }
            if(roomType.equalsIgnoreCase("Executive")){
                roomList.add(new Executive(roomList.size() + 1));
            }
        }
    }

    /**
     * Removes a room from the hotel.
     * Allows removal only if the room is not currently reserved.
     */
    public void removeRoom(int roomChoice) {
        if (roomChoice > 0 && roomChoice <= roomList.size()) {
            roomList.remove(roomChoice - 1);
            System.out.println("Room has been removed");
        } else {
            System.out.println("Room " + roomChoice + " cannot be removed or does not exist");
        }
    }

    private void updateRoomPrices(){
        for(Room room : roomList){
            room.setPrice(basePrice);
        } // goes to every existing room and updates the base prices
    }

    /**
     * Cancels a reservation in the hotel.
     *
     * @param reservation The reservation to cancel.
     */
    public void cancelReserve(Reservation reservation) {
        reservationList.remove(reservation);
        reservation.getRoomInfo().addAvail(reservation.getInDay(), reservation.getOutDay());
    }

    /**
     * Checks if a reservation can be booked for specified check-in and check-out dates.
     *
     * @param inDay  The check-in day.
     * @param outDay The check-out day.
     * @return True if a reservation can be booked, false otherwise.
     */
    public boolean canBookReservation(int inDay, int outDay) {
        for (Room room : roomList) {
            if (room.isAvailable(inDay, outDay)) {
                for (Reservation reservation : reservationList) {
                    if (reservation.getRoomInfo() == room) {
                        for (int day : reservation.getOccDays()) {
                            if (day >= inDay && day <= outDay) { 
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Books a reservation in the hotel for specified check-in and check-out dates.
     * Prompts for guest name and creates a new reservation.
     *
     * @param inDay  The check-in day.
     * @param outDay The check-out day.
     * @param guestName The guest name.
     * @param roomChoice The room choice.
     */
    public void bookReserve(int inDay, int outDay, String guestName, int roomChoice, String discountCode) {
        if (canBookReservation(inDay, outDay)) {
            if (roomList.get(roomChoice-1).isAvailable(inDay, outDay)) {
                Reservation reserve = new Reservation(guestName, inDay, outDay, roomList.get(roomChoice-1), discountCode);
                reservationList.add(reserve);
                System.out.println("Reservation has been booked");
                return;
            } else {
                System.out.println("Room " + roomChoice + " is not available for the specified dates");
            }
        } else {
            System.out.println("No rooms are available for the specified dates");
        }
    }

    /**
     * Calculates the total earnings from all reservations in the hotel.
     *
     * @return The total earnings.
     */
    public double calculateTotalEarnings() {
        return reservationList.stream().mapToDouble(Reservation::getBookPrice).sum();
    }

    public void printAvailableDaysForPriceChange() {
        System.out.println("Days available for price rate change:");
        boolean foundAvailable = false;
        for (int day = 1; day <= 31; day++) {
            boolean canChange = true;
            for (Room room : roomList) {
                if (!room.isAvailable(day, day + 1)) {
                    canChange = false;
                    break;
                }
            }
            if (canChange) {
                System.out.print(day + " ");
                foundAvailable = true;
            }
        }
        if (!foundAvailable) {
            System.out.println("No days available for price rate change.");
        }
        System.out.println("");
    }
    public void updatePriceRateForDay(int day, double rate) {
        for (Room room : roomList) {
            room.setPriceRate(day, rate);
        }
    }
}
