import java.util.ArrayList;

/**
 * Represents a reservation made by a guest for a room in a hotel.
 */
public class Reservation {
    private String guestName;
    private int inDay;
    private int outDay;
    private Room roomInfo;
    private double bookPrice;
    private ArrayList<Integer> occDays;

    /**
     * Constructs a new Reservation object.
     *
     * @param guestName The name of the guest making the reservation.
     * @param inDay     The day of check-in.
     * @param outDay    The day of check-out.
     * @param roomInfo  The Room object representing the room reserved.
     */
    public Reservation(String guestName, int inDay, int outDay, Room roomInfo) {
        this.guestName = guestName;
        this.inDay = inDay;
        this.outDay = outDay;
        this.roomInfo = roomInfo;
        this.bookPrice = calculateBookPrice();
        this.occDays = new ArrayList<>();

        // Mark all days from inDay to outDay (exclusive) as occupied
        for (int i = inDay; i < outDay; i++) {
            occDays.add(i);
        }

        // Change room availability in the Room object
        roomInfo.changeAvail(inDay, outDay);
    }

    /**
     * Retrieves the day of check-in.
     *
     * @return The day of check-in.
     */
    public int getInDay() {
        return inDay;
    }

    /**
     * Retrieves the day of check-out.
     *
     * @return The day of check-out.
     */
    public int getOutDay() {
        return outDay;
    }

    /**
     * Retrieves the total booking price for the reservation.
     *
     * @return The total booking price.
     */
    public double getBookPrice() {
        return bookPrice;
    }

    /**
     * Retrieves the guest's name associated with the reservation.
     *
     * @return The guest's name.
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Retrieves the Room object associated with the reservation.
     *
     * @return The Room object.
     */
    public Room getRoomInfo() {
        return roomInfo;
    }

    /**
     * Calculates and returns the total booking price based on the number of days
     * stayed and the price per night of the room.
     *
     * @return The calculated booking price.
     */
    public double calculateBookPrice() {
        double totalDays = outDay - inDay;
        return totalDays * roomInfo.getPricePerNight();
    }

    /**
     * Retrieves the list of days (as integers) that the room is occupied during
     * the reservation period.
     *
     * @return The list of occupied days.
     */
    public ArrayList<Integer> getOccDays() {
        return occDays;
    }
}
