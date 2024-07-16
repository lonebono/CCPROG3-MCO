import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a room in a hotel with availability and pricing information.
 */
public class Room {
    private int roomNumber;
    private double pricePerNight = 1299.0; // Example price
    private ArrayList<Integer> availability = new ArrayList<>();

    /**
     * Constructs a room with a specified room number.
     * Initializes availability for 30 days.
     *
     * @param roomNumber The room number.
     */
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        for (int i = 1; i <= 30; i++) { // Changed to 30 to prevent check-in on day 31
            availability.add(i);
        }
    }

    /**
     * Sets a new price per night for the room.
     *
     * @param newPrice The new price per night to set.
     */
    public void setPrice(double newPrice) {
        this.pricePerNight = newPrice;
    }

    /**
     * Retrieves the room number.
     *
     * @return The room number.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Retrieves the price per night for the room.
     *
     * @return The price per night.
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Retrieves the availability list of the room.
     *
     * @return The list of available days.
     */
    public ArrayList<Integer> getAvail() {
        return availability;
    }

    /**
     * Checks if the room is available for the specified check-in and check-out days.
     *
     * @param inDay  The check-in day.
     * @param outDay The check-out day.
     * @return True if the room is available for the specified period, false otherwise.
     */
    public boolean isAvailable(int inDay, int outDay) {
        if (inDay == 31 || outDay == 1) {
            return false;
        }
        for (int day = inDay; day < outDay; day++) {
            if (!availability.contains(day)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the room is available for a given list of occupancy days.
     *
     * @param occDays The list of occupancy days to check.
     * @return True if the room is available for all occupancy days, false otherwise.
     */
    public boolean roomCheck(ArrayList<Integer> occDays) {
        for (int day : occDays) {
            if (!availability.contains(day)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Updates the availability of the room based on check-in and check-out days.
     *
     * @param in  The check-in day.
     * @param out The check-out day.
     */
    public void changeAvail(int in, int out) {
        Iterator<Integer> iterator = availability.iterator();
        while (iterator.hasNext()) {
            int day = iterator.next();
            if (day >= in && day < out) {
                iterator.remove();
            }
        }
    }
}
