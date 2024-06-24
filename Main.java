import java.util.Scanner;

public class Main {

    public void HotelSystem(){
        Scanner scanOption = new Scanner(System.in);
        int option = scanOption.nextInt();

        while (option != 5){
            System.out.println("Enter your choice: ");
            System.out.println("[1] Create a Hotel. ");
            System.out.println("[2] View a Hotel. ");
            System.out.println("[3] Manage a Hotel. ");
            System.out.println("[4] Book a reservation. ");
            System.out.println("[5] Quit. ");

            if(option == 1){
                //ReserveSystem.addHotel();
            }
            if(option == 2){
                // view hotel
            }
            if(option == 3){
                // manage hotel
            }
            if(option == 4){
                // simulate booking
            }
        }
        scanOption.close();
    }
    public static void main(String[] args) {

    }
}