import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a hotel with rooms and reservations in a hotel reservation system.
 */
public class Hotel {
    private String hotelName;
    private ArrayList<Room> roomList = new ArrayList<>();
    private ArrayList<Reservation> reservationList = new ArrayList<>();
    private double basePrice = 1299.0; // Example base price

    /**
     * Constructs a hotel with a specified name.
     * Initializes with one room.
     *
     * @param hotelName The name of the hotel.
     */
    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        createRoom(); // call create room since room minimum is 1
    }

    /**
     * Creates a new room and adds it to the hotel's room list.
     * Restricts the maximum number of rooms to 50.
     */
    public void createRoom() {
        if (roomList.size() < 50) {
            roomList.add(new Room(roomList.size() + 1));
            System.out.println("Created Room Number " + roomList.size());
        }
    }

    /**
     * Removes a room from the hotel.
     * Allows removal only if the room is not currently reserved.
     */
    public void removeRoom() {
        System.out.println("Available rooms to remove:");
        ArrayList<Integer> removableRooms = new ArrayList<>();
        for (int i = 0; i < roomList.size(); i++) {
            boolean removable = true;
            for (Reservation res : reservationList) {
                if (res.getRoomInfo().getRoomNumber() == i + 1) {
                    removable = false;
                    break;
                }
            }
            if (removable) {
                removableRooms.add(i + 1);
                System.out.println("Room " + (i + 1));
            }
        }

        System.out.println("Remove Room: ");
        Scanner sc = new Scanner(System.in);
        int roomChoice = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (!removableRooms.contains(roomChoice)) {
            System.out.println("Room " + roomChoice + " cannot be removed or does not exist");
            sc.close();
            return;
        }

        System.out.println("Confirm Removal of Room " + roomChoice + " YES[1] NO[Any Other Number]");
        int yesNo = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (yesNo == 1) {
            roomList.remove(roomChoice - 1);
            System.out.println("Room has been removed");
        }
        sc.close();
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
            System.out.println("Base price has been updated!");
        } else {
            System.out.println("An existing reservation exists. Cannot change base price.");
        }
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
     * Cancels a reservation in the hotel.
     *
     * @param reservation The reservation to cancel.
     */
    public void cancelReserve(Reservation reservation) {
        reservationList.remove(reservation);
        reservation.getRoomInfo().changeAvail(reservation.getInDay(), reservation.getOutDay());
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
     */
    public void bookReserve(int inDay, int outDay) {
        for (Room room : roomList) {
            if (room.isAvailable(inDay, outDay)) {
                System.out.println("Enter your name: ");
                Scanner sc = new Scanner(System.in);
                String guestName = sc.nextLine();

                Reservation reserve = new Reservation(guestName, inDay, outDay, room);
                reservationList.add(reserve);
                System.out.println("Reservation has been booked");
                sc.close();
                return;
            }
        }
        System.out.println("There are no available rooms for that date. Please create another booking");
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
     * Calculates the total earnings from all reservations in the hotel.
     *
     * @return The total earnings.
     */
    public double calculateTotalEarnings() {
        return reservationList.stream().mapToDouble(Reservation::getBookPrice).sum();
    }

    /**
     * Sets a new name for the hotel.
     *
     * @param newHotelName The new name to set for the hotel.
     */
    public void setHotelName(String newHotelName) {
        this.hotelName = newHotelName;
    }
}
