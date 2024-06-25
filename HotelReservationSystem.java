import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    private List<Hotel> hotels;

    public HotelReservationSystem() {
        this.hotels = new ArrayList<>();
    }

    public boolean createHotel(String name) {
        for (Hotel hotel : hotels)
            if (name.equals(hotel.getName()))
                return false;
        hotels.add(new Hotel(name));
        return true;
    }

    public boolean changeHotel(Hotel hotel, String name) {

        for (Hotel h : hotels)
            if (name.equals(h.getName())) {
                return false;
            }

        hotel.setName(name);

        return true;

    }

    public boolean removeHotel(Hotel hotel) {
        return hotels.remove(hotel);
    }

    public boolean simulateBooking(Hotel hotel, String guestName, int checkIn, int checkOut) {
        Room availableRoom = null;
        for (Room room : hotel.getRooms()) {
            if (room.checkAvailableInterval(checkIn, checkOut)) {
                availableRoom = room;
                break;
            }
        }
        if (availableRoom == null || checkIn>checkOut) {
            return false;
        }

        Reservation newReservation = new Reservation(guestName, checkIn, checkOut, availableRoom);
        hotel.getReservations().add(newReservation);

        availableRoom.setBookedInterval(checkIn, checkOut);
        return true;
    }

    public void viewHigh(Hotel hotel) {
        System.out.println("Hotel Name: " + hotel.getName());
        System.out.println("Total Rooms: " + hotel.getTotalRooms());
        System.out.println("Estimated Earnings: " + hotel.calculateEarnings());
    }

    public void viewLow(Hotel hotel, int day) {

        System.out.println("Total Available Rooms: " + hotel.getAvailableRooms(day));
        System.out.println("Total Booked Rooms: " + hotel.getBookedRooms(day));
    }

    public Hotel getHotel(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(name)) {
                return hotel;
            }
        }
        return null;
    }

    public void printAllHotels() {
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getName());
        }
    }
}