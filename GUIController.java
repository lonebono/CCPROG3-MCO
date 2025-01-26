package MCO2.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController implements ActionListener {
    private MainGUIView view;
    private ReserveSystem reserveSystem;
    private CreateHotelGUI createHotelGUI;
    private ViewHotelGUI viewHotelGUI;
    private ManageHotelGUI manageHotelGUI;
    private BookRoomGUI bookRoomGUI;

    public GUIController(MainGUIView view, ReserveSystem reserveSystem, 
                     CreateHotelGUI createHotelGUI, ViewHotelGUI viewHotelGUI,
                     ManageHotelGUI manageHotelGUI, BookRoomGUI bookRoomGUI) {
        this.view = view;
        this.reserveSystem = reserveSystem;
        this.createHotelGUI = createHotelGUI;
        this.viewHotelGUI = viewHotelGUI;
        this.manageHotelGUI = manageHotelGUI;
        this.bookRoomGUI = bookRoomGUI;

        view.addCard(createHotelGUI, "Create");
        view.addCard(viewHotelGUI, "View");
        view.addCard(manageHotelGUI, "Manage");
        view.addCard(bookRoomGUI, "Book");

        // add action listeners to buttons
        view.getBtnCreate().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("Create");
                updateCreateHotelView();
            }
        });

        view.getBtnView().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("View");
            }
        });

        view.getBtnManage().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("Manage");
                updateManageHotelView();
            }
        });

        view.getBtnBook().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("Book");
                updateBookRoomView();
            }
        });

        // Set up action listeners for other buttons
        createHotelGUI.getCreateHotelSubmit().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleCreateHotelSubmit();
            }
        });

        bookRoomGUI.getBookRoomSubmit().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleBookRoomSubmit();
            }
        });
    }

    private void updateCreateHotelView() {
        // Add logic to update the ViewHotelView
        // For example, create a hotel
        // Clear input fields
        createHotelGUI.getInputHotelName().setText(""); 
        createHotelGUI.getCreateRoomType().setText(""); 

        // Update the hotel list
        String hotelListText = "";
        for (Hotel hotel : reserveSystem.getHotelList()) {
            hotelListText += hotel.getHotelName() + "\n";
        }
        createHotelGUI.getCreateTextInfo().setText(hotelListText);
    }

    public void updateViewHotelView(String selectedHotel) {
        Hotel hotel = null;
        for (Hotel h : reserveSystem.getHotelList()) {
            if (h.getHotelName().equals(selectedHotel)) {
                hotel = h;
                break;
            }
        }
        if (hotel != null) {
            viewHotelGUI.getViewHotelInfo().setText("Hotel: " + hotel.getHotelName() + "\n" +
                    "Number of rooms: " + hotel.getRoomList().size() + "\n" +
                    "Estimated earnings for the month: " + hotel.calculateTotalEarnings());
        } else {
            viewHotelGUI.getViewHotelInfo().setText("Hotel not found");
        }
    }
    
    private void updateLowLevelOptionsComboBox() {
        viewHotelGUI.getLowOptions().removeAllItems();
        viewHotelGUI.getLowOptions().addItem("Rooms");
        viewHotelGUI.getLowOptions().addItem("Reservations");
        
    }
    
    private void updateViewDateComboBox() {
        viewHotelGUI.getViewDate().removeAllItems();
        // Populate the view date JComboBox with dates (e.g., from a calendar)
        for (int i = 1; i <= 31; i++) {
            viewHotelGUI.getViewDate().addItem(String.valueOf(i));
        }
    }
    
    private void updateViewRoomComboBox() {
        viewHotelGUI.getViewRoom().removeAllItems();
        
    }
    
    private void updateViewReservationComboBox() {
        viewHotelGUI.getViewReserve().removeAllItems();
        
    }

    private void updateManageHotelView() {
    }

    private void updateBookRoomView() {
        // Update the bookHotels JComboBox
        updateBookHotelsComboBox();

        // Update the bookInInput JComboBox
        updateBookInInputComboBox();

        // Update the bookOutInput JComboBox
        updateBookOutInputComboBox();
    }

    private void handleCreateHotelSubmit() {
        // Extract data from CreateHotelView
        String hotelName = createHotelGUI.getInputHotelName().getText().trim();
        String roomType = createHotelGUI.getCreateRoomType().getText().trim();
        if (hotelName.isEmpty()) {
            createHotelGUI.getInputFeedback().setText("Hotel name cannot be empty.");
            return;
        }
        // Check if hotel already exists
        for (Hotel hotel : reserveSystem.getHotelList()) {
            if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                createHotelGUI.getInputFeedback().setText("Hotel already exists.");
                return;
            }
        }
        // Check if room type is valid
        if (!isValidRoomType(roomType)) {
            createHotelGUI.getInputFeedback().setText("Invalid room type.");
            return;
        }
        // Add hotel to the model
        reserveSystem.addHotel(hotelName);

        // Find the newly added hotel and add room to it
        for (Hotel hotel : reserveSystem.getHotelList()) {
            if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                hotel.createRoom(roomType);
                System.out.println("Rooms in hotel " + hotelName + ": " + hotel.getRoomList());
                break;
            }
        }   
        createHotelGUI.getInputFeedback().setText("Hotel successfully added");
        updateCreateHotelView();
    }

    private boolean isValidRoomType(String roomType) {
        return roomType.equalsIgnoreCase("Standard") || roomType.equalsIgnoreCase("Deluxe") || roomType.equalsIgnoreCase("Executive");
    }

    private void handleBookRoomSubmit() {
        // Get the selected values from the JComboBoxes
        String hotelName = (String) bookRoomGUI.getBookHotels().getSelectedItem();
        String roomSelection = (String) bookRoomGUI.getBookRooms().getSelectedItem();
        if (roomSelection == null) {
            bookRoomGUI.getBookFeedbackInput().setText("Please select a room");
            return;
        }
        String[] roomInfo = roomSelection.split(" - ");
        int roomNumber = Integer.parseInt(roomInfo[0].substring(5));
        int inDay = (int) bookRoomGUI.getBookInInput().getSelectedItem();
        int outDay = (int) bookRoomGUI.getBookOutInput().getSelectedItem();

        // Check that the outDay is greater than the inDay
        if (outDay <= inDay) {
            bookRoomGUI.getBookFeedbackInput().setText("Check-out day must be later than check-in day");
            return;
        }
        
        // Get the text from the JTextFields
        String name = bookRoomGUI.getBookNameInput().getText();
        if (bookRoomGUI.getBookNameInput().getText().isEmpty()) {
            bookRoomGUI.getBookFeedbackInput().setText("Please enter a name.");
            return;
        }
        String discountCode = bookRoomGUI.getBookDiscountInput().getText(); // get the discount code from the JTextField
        
        // Validate the input and add the reservation to the hotel's arraylist of reservation objects
        Hotel selectedHotel = null;
        for (Hotel hotel : reserveSystem.getHotelList()) {
            if (hotel.getHotelName().equals(hotelName)) {
                selectedHotel = hotel;
                break;
            }
        }
        if (selectedHotel != null) {
            Room room = null;
            for (Room r : selectedHotel.getRoomList()) {
                if (r.getRoomNumber() == roomNumber) {
                    room = r;
                    break;
                }
            }
            if (room != null) {
                Reservation reservation = new Reservation(name, inDay, outDay, room, discountCode); // pass the discountCode variable to the Reservation constructor
                selectedHotel.getReservationList().add(reservation);
                bookRoomGUI.getBookFeedbackInput().setText("Reservation Success");
            } else {
                bookRoomGUI.getBookFeedbackInput().setText("Invalid room number");
            }
        } else {
            bookRoomGUI.getBookFeedbackInput().setText("Hotel not found");
        }
    }

    private void updateBookHotelsComboBox() {
        bookRoomGUI.getBookHotels().removeAllItems();
        for (Hotel hotel : reserveSystem.getHotelList()) {
            bookRoomGUI.getBookHotels().addItem(hotel.getHotelName());
        }
    }

    public void updateBookRoomsComboBox() {
        bookRoomGUI.updateBookRooms();
    }

    private void updateBookInInputComboBox() {
        bookRoomGUI.getBookInInput().removeAllItems();
        // You need to add days of the month to this JComboBox
        for (int i = 1; i <= 31; i++) {
            bookRoomGUI.getBookInInput().addItem(i);
        }
    }

    private void updateBookOutInputComboBox() {
        bookRoomGUI.getBookOutInput().removeAllItems();
        // You need to add days of the month to this JComboBox
        for (int i = 1; i <= 31; i++) {
            bookRoomGUI.getBookOutInput().addItem(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This method is not used in the current implementation
        // It's a placeholder for future implementation or can be removed
    }
    
    //ALL OF THE ACTIONS MUST FOLLOW MVC
}
