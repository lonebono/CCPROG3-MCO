import java.util.Scanner;

public class Reservation {
    Scanner sc = new Scanner(System.in);

    private String guestName;
    private Date inDate;
    private Date outDate;
    private Room roomInfo;
    private double bookPrice;
    private double costBreak;

    //

    public Reservation(String guestName) {
        this.guestName = guestName;
        
        System.out.println("Enter Book-In Month:");
        int inMonth = sc.nextInt();
        System.out.println("Enter Book-In Date:");
        int inDay = sc.nextInt();
        System.out.println("Enter Book-In Year:");
        int inYear = sc.nextInt();

        this.inDate = new Date(inMonth, inDay, inYear);

        System.out.println("Enter Book-Out Month:");
        int outMonth = sc.nextInt();
        System.out.println("Enter Book-Out Date:");
        int outDay = sc.nextInt();
        System.out.println("Enter Book-Out Year:");
        int outYear = sc.nextInt();

        this.outDate = new Date(outMonth, outDay, outYear);
    }
}