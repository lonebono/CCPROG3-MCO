import java.util.Arrays;

public class Room {
    private final String name;
    private double basePricePerNight;

    Boolean[] available = new Boolean[31];

    public Room(String name) {
        this.name = name;
        this.basePricePerNight = 1299.0;
        Arrays.fill(this.available, Boolean.TRUE);
    }

    public boolean checkAvailable(int day) {
        return this.available[day];
    }

    public boolean checkAvailableInterval(int checkIn, int checkOut) {

        for (int i = checkIn-1; i<checkOut; i++)
            if(!this.available[i])
                return false;
        return true;
    }

    public void setAvailableInterval(int checkIn, int checkOut) {
        for (int i = checkIn-1; i<checkOut; i++)
          this.available[i] = true;
    }

    public void setBookedInterval(int checkIn, int checkOut) {
        for (int i = checkIn-1; i<checkOut; i++)
            this.available[i] = false;
    }

    public String getName() {
        return name;
    }

    public double getBasePricePerNight() {
        return basePricePerNight;
    }

    public void setBasePricePerNight(double pricePerNight)
    {
        this.basePricePerNight = pricePerNight;
    }

}