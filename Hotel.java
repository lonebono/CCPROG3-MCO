import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();

        Room newRoom = new Room("100");
        rooms.add(newRoom);
    }

    public boolean addRoom(String roomName) {
        if (rooms.size() >= 50) {
            return false;
        }
        for (Room room : rooms) {
            if (room.getName().equals(roomName)) {
                return false;
            }
        }

        Room newRoom = new Room(roomName);
        rooms.add(newRoom);

        return true;
    }

    public boolean removeRoom(String roomName) {
        Room room = null;
        for (Room r : rooms) {
            if (r.getName().equals(roomName)) {
                room = r;
                break;
            }
        }
        if (room == null || rooms.size() == 1) {
            return false;
        }
        for (Reservation res : reservations) {
            if (res.getRoom().getName().equals(roomName)) {
                return false;
            }
        }
        return rooms.remove(room);
    }

    public double calculateEarnings() {
        double earnings = 0;
        for (Reservation res : reservations) {
            earnings += res.calculateTotalPrice();
        }
        return earnings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public int getTotalRooms() {
        return rooms.size();
    }

    public int getAvailableRooms(int day) {
        int availableCount = 0;
        for (Room room : rooms) {
            if (room.checkAvailable(day)) {
                availableCount++;
            }
        }
        return availableCount;
    }

    public boolean updateBasePrice(double pricePerNight)
    {
        if(pricePerNight < 100 || !reservations.isEmpty())
        {
            return false;
        }

        for (Room room : rooms)
            room.setBasePricePerNight(pricePerNight);
        return true;
    }

    public int getBookedRooms(int day) {
        return getTotalRooms() - getAvailableRooms(day);
    }

    public Room getRoomByName(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equals(roomName)) {
                return room;
            }
        }
        return null;
    }
    
    public Reservation getReservationByGuestName(String guestName) {
        for (Reservation res : reservations) {
            if (res.getGuestName().equals(guestName)) {
                return res;
            }
        }
        return null;
    }

    public boolean removeReservation(Hotel hotel, Reservation reservation) {
        if (reservations.remove(reservation)) {
                reservation.getRoom().setAvailableInterval(reservation.getCheckIn(), reservation.getCheckOut());
            return true;
        }
        return false;
    }

    public void printAllReservations() {
        for (Reservation r : reservations) {
            System.out.println(r.getGuestName());
            System.out.println(r.getRoom().getName());
            System.out.println(r.getCheckIn() + "-" + r.getCheckOut());
            System.out.println(r.calculateTotalPrice());
            System.out.println();
        }
    }

    public void printAllRooms() {
        for (Room r : rooms) {
            System.out.println(r.getName());
        }
    }
}
