package MCO2.src;
import java.util.Scanner;

/**
 * This class implements a simple Hotel Reservation System with a menu-driven interface.
 */
public class Main {

    /**
     * Main method to run the Hotel Reservation System.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Initialize Scanner object for user input
        Scanner scanOption = new Scanner(System.in);
        // Initialize the ReserveSystem object
        ReserveSystem reserveSystem = new ReserveSystem();
        /* 
        // Loop to display menu and handle user input
        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("[1] Create Hotel");
            System.out.println("[2] View Hotel");
            System.out.println("[3] Manage Hotel");
            System.out.println("[4] Book Reservation");
            System.out.println("[5] Quit");

            int choice = 0;
            try {
                System.out.print("Enter your choice: ");
                // Read user's choice
                choice = scanOption.nextInt();
                scanOption.nextLine(); // Consume newline after integer input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace(); // Prints the stack trace to the console
            }

            switch (choice) {
                case 1:
                    // Call method to add a new hotel
                    reserveSystem.addHotel();
                    break;
                case 2:
                    // Call method to view hotel information
                    reserveSystem.viewHotel();
                    break;
                case 3:
                    // Call method to manage hotel (update/delete)
                    reserveSystem.manageHotel();
                    break;
                case 4:
                    // Call method to book a reservation
                    reserveSystem.bookReserve();
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exit.");
                    // Close Scanner object
                    scanOption.close();
                    return;
                default:
                    // Handle invalid input
                    System.out.println("Invalid choice. Please enter a valid option.");
                    
            }
        }*/
    }
}