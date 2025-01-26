package MCO2.src;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a room in a hotel with availability and pricing information.
 */
public class Room {
    private int roomNumber;
    protected double pricePerNight = 1299.0; // Base Price
    private ArrayList<Integer> availability = new ArrayList<>(); // private works
    private double[] priceRates = new double[31]; // array to hold price rates for each day
    protected String roomType;

    /**
     * Constructs a room with a specified room number.
     * Initializes availability for 31 days.
     *
     * @param roomNumber The room number.
     * @param roomType The type of room.
     */
    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        for (int i = 0; i < 31; i++) { 
            availability.add(i+1);
            priceRates[i] = 1.0; //initialise to 100% at room creation
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

    public void setPriceRate(int day, double rate) {
        if (day >= 1 && day <= 31) {
            priceRates[day-1] = rate;
        }
    }

    /**
     * Retrieves the room number.
     *
     * @return The room number.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }
    
    public double getPriceRate(int day) {
        return priceRates[day - 1];
    }

    /**
     * Retrieves the price per night for the room.
     *
     * @return The price per night.
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    public double getTotalRate(int inDay, int outDay) {
        double totalRate = 0.0;

        for(int i = inDay - 1; i < outDay - 1; i++) {
            totalRate += priceRates[i];
        }
        
        return totalRate;
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
        if (inDay < 1 || outDay > 31) {
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
    public void removeAvail(int in, int out) {
        Iterator<Integer> iterator = availability.iterator();
        while (iterator.hasNext()) {
            int day = iterator.next();
            if (day >= in && day < out) {
                iterator.remove();
            }
        }
    }

    public void addAvail(int in, int out) {
        for(int i = 0; i < out - in; i++) {
            availability.add(in - 1, in);
            in++;
        }
    }

    public String getRoomName() {
        return "Room " + roomNumber + " - " + roomType;
    }
}