package MCO2.src;

import java.util.ArrayList;

/**
 * Represents a reservation made by a guest for a room in a hotel.
 */
public class Reservation {
    private String guestName;
    private int inDay;
    private int outDay;
    private Room roomInfo;
    private double bookPrice; // could be edited out
    private ArrayList<Integer> occDays = new ArrayList<>();
    private int discountNum = 0;

    /**
     * Constructs a new Reservation object.
     *
     * @param guestName The name of the guest making the reservation.
     * @param inDay     The day of check-in.
     * @param outDay    The day of check-out.
     * @param roomInfo  The Room object representing the room reserved.
     * @param discountCode The discount code entered by the guest.
     */
    public Reservation(String guestName, int inDay, int outDay, Room roomInfo, String discountCode) {
        this.guestName = guestName;
        this.inDay = inDay;
        this.outDay = outDay;
        this.roomInfo = roomInfo;
        this.bookPrice = calculateBookPrice(discountCode);
        this.occDays = new ArrayList<>();

        // Mark all days from inDay to outDay (exclusive) as occupied
        for (int i = inDay; i < outDay; i++) {
            occDays.add(i);
        }

        // Change room availability in the Room object
        roomInfo.removeAvail(inDay, outDay);
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
     * Retrieves the Room object associated with the reservation.
     *
     * @return The Room object.
     */
    public Room getRoomInfo() {
        return roomInfo;
    }

    public int getTotalDays() {
        return outDay - inDay;
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
    
    /**
     * Calculates and returns the total booking price based on the number of days
     * stayed and the price per night of the room.
     *
     * @return The calculated booking price.
     */
    public double calculateBookPrice(String discountCode) {
        if(discountCode.equals("I_WORK_HERE")) {
            discountNum = 1;
        } else if(discountCode.equals("STAY4_GET1") && getTotalDays() >= 5) {
            discountNum = 2;
        } else if (discountCode.equals("PAYDAY") && isPayDay() && !(outDay == 15 || outDay == 30)) {
            discountNum = 3;
        } else {
            discountNum = 0;
        }
        
        switch(discountNum) {
            case 1: return (roomInfo.getPricePerNight() * getTotalDays()) * 0.9;
            case 2: return roomInfo.getPricePerNight() * (getTotalDays() - 1);
            case 3: return (roomInfo.getPricePerNight() * getTotalDays()) * 0.93;
            default: return roomInfo.getPricePerNight() * getTotalDays();
        }
    }

    public boolean isPayDay() {
        for (int i = inDay; i < outDay; i++) {
            if(i == 15 || i == 30) {
                return true;
            }
        }
        return false;
    }

    public boolean isMoreThan4() {
        return getTotalDays() >= 5;
    }
}