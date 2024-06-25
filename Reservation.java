import java.util.Date;

public class Reservation {
    private final String guestName;
    private final int checkIn;
    private final int checkOut;
    private final Room room;
    private double totalPrice;

    public Reservation(String guestName, int checkIn, int checkOut, Room room) {
        this.guestName = guestName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getCheckIn() {
        return checkIn;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public Room getRoom() {
        return room;
    }

    public double calculateTotalPrice() {
        int totalDays = checkOut - checkIn;
        return totalDays * room.getBasePricePerNight();
    }
}