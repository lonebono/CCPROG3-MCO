import java.util.ArrayList;

public class Reservation {
    private String guestName;
    private int inDay;
    private int outDay;
    private Room roomInfo;
    private double bookPrice;
    private ArrayList<Integer> occDays;

    public Reservation(String guestName, int inDay, int outDay, Room roomInfo) {
        this.guestName = guestName;
        this.inDay = inDay;
        this.outDay = outDay;
        this.roomInfo = roomInfo;
        this.bookPrice = calculateBookPrice();
        this.occDays = new ArrayList<>();
        
        for (int i = inDay; i < outDay; i++) {
            occDays.add(i);
        }
        
        roomInfo.changeAvail(inDay, outDay); // Change room availability
    }
   
    public int getInDay() {
        return inDay;
    }

    public int getOutDay() {
        return outDay;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public String getGuestName() {
        return guestName;
    }

    public double calculateBookPrice() {
        double totalDays = outDay - inDay;
        return totalDays * roomInfo.getPricePerNight();
    }

    public ArrayList<Integer> getOccDays() {
        return occDays;
    }
}