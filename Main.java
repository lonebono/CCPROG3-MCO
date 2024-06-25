import java.util.Scanner;

public class Main {

    public static void newline() {
        System.out.println();
    }

    public static void main(String[] args) {
        HotelReservationSystem hrs = new HotelReservationSystem();
        boolean exit = false;
        boolean temp;

        while(!exit) {
            String var = "";
            String var2 = "";
            String var3 = "";

            System.out.println("List of Hotels: ");
            hrs.printAllHotels();
            System.out.println("\n[0] Create Hotel\n[1] Simulate Booking");

            Scanner scanner = new Scanner(System.in);
            String val = scanner.nextLine();

            if ("0".equals(val)) {
                String hotelName = scanner.nextLine();
                temp = hrs.createHotel(hotelName);
                if(!temp)
                {
                    System.out.println("already exists!");
                }
            }
            else if ("1".equals(val))
            {
                var = scanner.nextLine();

                if(hrs.getHotel(var) != null)
                {
                    System.out.print("Enter Guest Name: ");
                    var2 = scanner.nextLine();
                    System.out.print("Enter Check In: ");
                    int var4 = scanner.nextInt();
                    System.out.print("Enter Check Out: ");
                    int var5 = scanner.nextInt();


                    temp = hrs.simulateBooking(hrs.getHotel(var), var2, var4, var5);
                    if (temp)
                    {
                        System.out.println("success!");
                    }
                    else
                    {
                        System.out.println("fail!");
                    }

                }
                else
                {
                    System.out.println("hotel not found!");
                }
            }
            else if ("exit".equals(val))
            {
                exit = true;
            }
            else {
                if (hrs.getHotel(val) == null)
                {
                    System.out.print("no hotel found!");
                }
                else
                {
                    while(!"0".equals(var)) {
                        var2 = "";
                        newline();
                        Hotel local = hrs.getHotel(val);
                        System.out.println("[1] High-level\n[2] Low-level\n[3] Manage\n[0] Previous");
                        var = scanner.nextLine();

                        if ("1".equals(var))
                        {
                            newline();
                            hrs.viewHigh(local);
                        }
                        else if ("2".equals(var))
                        {
                            System.out.print("Enter Day: ");
                            int Day = scanner.nextInt();

                            newline();
                            hrs.viewLow(local, Day);
                        }
                        else if ("3".equals(var))
                        {
                            while(!"0".equals(var2))
                            {
                                newline();
                                System.out.println("[1] Change Hotel Name\n[2] Add Room\n[3] Remove Room\n[4] Update Base Price\n[5] Remove Reservation\n[6] Remove Hotel\n[0] Previous");
                                var2 = scanner.nextLine();

                                if("1".equals(var2))
                                {
                                    System.out.print("Enter New Name: ");
                                    var3 = scanner.nextLine();
                                    temp = hrs.changeHotel(local, var3);
                                    if (temp)
                                    {
                                        System.out.println("success!");
                                    }
                                    else
                                    {
                                        System.out.println("already exists!");
                                    }
                                }
                                else if ("2".equals(var2))
                                {
                                    var3 = scanner.nextLine();
                                    temp = local.addRoom(var3);
                                    if (temp)
                                    {
                                        System.out.println("success!");
                                    }
                                    else
                                    {
                                        System.out.println("fail!");
                                    }
                                }
                                else if ("3".equals(var2))
                                {
                                    local.printAllRooms();
                                    var3 = scanner.nextLine();
                                    temp = local.removeRoom(var3);
                                    if (temp)
                                    {
                                        System.out.println("success!");
                                    }
                                    else
                                    {
                                        System.out.println("fail!");
                                    }
                                }
                                else if ("4".equals(var2))
                                {
                                    Scanner scanner1 = new Scanner(System.in);
                                    System.out.print("Enter Double: ");
                                    double var8 = scanner1.nextDouble();

                                    temp = local.updateBasePrice(var8);
                                    if (temp)
                                    {
                                        System.out.println("success!");
                                    }
                                    else
                                    {
                                        System.out.println("fail!");
                                    }

                                }
                                else if ("5".equals(var2))
                                {

                                    local.printAllReservations();
                                    var3 = scanner.nextLine();
                                    temp = local.removeReservation(local, local.getReservationByGuestName(var3));
                                    if (temp)
                                    {
                                        System.out.print("success!");
                                    }
                                    else
                                    {
                                        System.out.print("fail!");
                                    }
                                }
                                else if ("6".equals(var2))
                                {
                                    temp = hrs.removeHotel(local);
                                    if (temp)
                                    {
                                        System.out.print("success!");
                                    }
                                    else
                                    {
                                        System.out.print("no hotel found!");
                                    }
                                    var2 = "0";
                                    var = "0";
                                }
                                else if (!"0".equals(var2))
                                {
                                    System.out.println("wrong input!");
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("\n");
        }
    }
}