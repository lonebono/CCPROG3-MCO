import java.util.Scanner;

public class Reservation {
    Scanner sc = new Scanner(System.in);

    private String guestName;
    private int inDay;
    private int outDay;
    private Room roomInfo;
    private double bookPrice;
    private double costBreak;

    //

    public Reservation(String guestName, int inDay, int outDay, Room roomInfo) {
        this.guestName = guestName;
        this.inDay = inDay;
        this.outDay = outDay;
        this.roomInfo = roomInfo;
    }
    
    public int getInDay() {
        return inDay;
    }

    public int getOutDay() {
        return outDay;
    }

    public boolean canBook(int inComp, int outComp) {
        if ((inDay == inComp) || (outDay == outComp) //same day in or out
        || ((inDay < inComp) && (outDay > inComp)) //new bookIn is within a reservation
        || ((inDay < outComp) && (outDay > outComp)) //new bookOut is within a reservation
        ) {
            return false;
        }
        else return true;
    }
}