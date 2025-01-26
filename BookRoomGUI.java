package MCO2.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookRoomGUI extends JPanel {
    private JButton bookRoomSubmit;
    private JComboBox<String> bookHotels, bookRooms;
    private JComboBox<Integer> bookInInput, bookOutInput;
    private JTextField bookNameInput, bookFeedbackInput, bookDiscountInput;
    private ReserveSystem reserveSystem;

    public BookRoomGUI(ReserveSystem reserveSystem) {
        this.reserveSystem = reserveSystem;

        // Book Reservation Panel
        setLayout(new BorderLayout());
        JPanel bookList = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBookList = new GridBagConstraints();
        gbcBookList.insets = new Insets(0, 0, 10, 0);
        JPanel bookInput = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBookInput = new GridBagConstraints();
        gbcBookInput.insets = new Insets(0, 0, 10, 0);

        setBackground(Color.GRAY);

        // Booking Information
        bookList.setPreferredSize(new Dimension(400, 600));
        add(bookList, BorderLayout.WEST);

        JLabel bookHotelLabel = new JLabel("Select Hotel: ");
        gbcBookList.gridx = 0;
        gbcBookList.gridy = 0;
        bookList.add(bookHotelLabel, gbcBookList);

        bookHotels = new JComboBox<>();
        gbcBookList.gridx = 1;
        gbcBookList.gridy = 0;
        bookHotels.setPreferredSize(new Dimension(200, 20));
        bookList.add(bookHotels, gbcBookList);

        JLabel bookRoomsLabel = new JLabel("Select Room: ");
        gbcBookList.gridx = 0;
        gbcBookList.gridy = 1;
        bookList.add(bookRoomsLabel, gbcBookList);

        bookRooms = new JComboBox<>();
        gbcBookList.gridx = 1;
        gbcBookList.gridy = 1;
        bookRooms.setPreferredSize(new Dimension(200, 20));
        bookList.add(bookRooms, gbcBookList);

        // Booking Input
        bookInput.setPreferredSize(new Dimension(400, 600));
        add(bookInput, BorderLayout.EAST);

        JLabel bookFeedbackLabel = new JLabel("Feedback:", JLabel.CENTER);
        gbcBookInput.gridx = 0;
        gbcBookInput.gridy = 0;
        bookInput.add(bookFeedbackLabel, gbcBookInput);

        bookFeedbackInput = new JTextField(15);
        gbcBookInput.gridx = 1;
        gbcBookInput.gridy = 0;
        bookFeedbackInput.setEditable(false);
        bookInput.add(bookFeedbackInput, gbcBookInput);

        JLabel bookNameLabel = new JLabel("Name:", JLabel.CENTER);
        gbcBookInput.gridx = 0;
        gbcBookInput.gridy = 1;
        bookInput.add(bookNameLabel, gbcBookInput);

        bookNameInput = new JTextField(15);
        gbcBookInput.gridx = 1;
        gbcBookInput.gridy = 1;
        bookInput.add(bookNameInput, gbcBookInput);

        JLabel bookDiscountLabel = new JLabel("Discount Code:", JLabel.CENTER);
        gbcBookInput.gridx = 0;
        gbcBookInput.gridy = 2;
        bookInput.add(bookDiscountLabel, gbcBookInput);

        bookDiscountInput = new JTextField(15);
        gbcBookInput.gridx = 1;
        gbcBookInput.gridy = 2;
        bookInput.add(bookDiscountInput, gbcBookInput);

        JLabel bookInLabel = new JLabel("Check-In Day:", JLabel.CENTER);
        gbcBookInput.gridx = 0;
        gbcBookInput.gridy = 3;
        bookInput.add(bookInLabel, gbcBookInput);

        bookInInput = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            bookInInput.addItem(i);
        }
        gbcBookInput.gridx = 1;
        gbcBookInput.gridy = 3;
        bookInInput.setPreferredSize(new Dimension(50, 20));
        bookInput.add(bookInInput, gbcBookInput);

        JLabel bookOutLabel = new JLabel("Check-Out Day:", JLabel.CENTER);
        gbcBookInput.gridx = 0;
        gbcBookInput.gridy = 4;
        bookInput.add(bookOutLabel, gbcBookInput);

        bookOutInput = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            bookOutInput.addItem(i);
        }
        gbcBookInput.gridx = 1;
        gbcBookInput.gridy = 4;
        bookOutInput.setPreferredSize(new Dimension(50, 20));
        bookInput.add(bookOutInput, gbcBookInput);

        bookRoomSubmit = new JButton("Submit");
        gbcBookInput.gridx = 0;
        gbcBookInput.gridy = 5;
        gbcBookInput.gridwidth = 2;
        bookInput.add(bookRoomSubmit, gbcBookInput);

        // Populate bookHotels JComboBox with hotel names
        for (Hotel hotel : reserveSystem.getHotelList()) {
            bookHotels.addItem(hotel.getHotelName());
        }

        // Add ActionListener to bookHotels JComboBox
        bookHotels.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBookRooms();
            }
        });

        // Add ActionListener to bookInInput JComboBox
        bookInInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBookOutInput();
            }
        });
    }

    public JComboBox<String> getBookHotels() {
        return bookHotels;
    }

    public JComboBox<String> getBookRooms() {
        return bookRooms;
    }

    public JTextField getBookNameInput() {
        return bookNameInput;
    }

    public JComboBox<Integer> getBookInInput() {
        return bookInInput;
    }

    public JComboBox<Integer> getBookOutInput() {
        return bookOutInput;
    }

    public JButton getBookRoomSubmit() {
        return bookRoomSubmit;
    }

    public JTextField getBookFeedbackInput() {
        return bookFeedbackInput;
    }
    
    public JTextField getBookDiscountInput() {
        return bookDiscountInput;
    }

    public void updateBookRooms() {
        bookRooms.removeAllItems();
        Object selectedItem = bookHotels.getSelectedItem();
        if (selectedItem != null) {
            String selectedHotelName = selectedItem.toString();
            Hotel selectedHotel = null;
            for (Hotel hotel : reserveSystem.getHotelList()) {
                if (hotel.getHotelName().equals(selectedHotelName)) {
                    selectedHotel = hotel;
                    break;
                }
            }
            if (selectedHotel != null) {
                System.out.println("Selected hotel: " + selectedHotel.getHotelName());
                System.out.println("Room list size: " + selectedHotel.getRoomList().size());
                for (Room room : selectedHotel.getRoomList()) {
                    System.out.println("Adding room: " + room.getRoomNumber() + " - " + room.getRoomType());
                    bookRooms.addItem("Room " + room.getRoomNumber() + " - " + room.getRoomType());
                }
            } else {
                System.out.println("Selected hotel is null");
            }
        } else {
            System.out.println("No hotel selected");
        }
    }

    public void updateBookOutInput() {
        bookOutInput.removeAllItems();
        Object selectedItem = bookInInput.getSelectedItem();
        if (selectedItem != null) {
            int inDay = (int) selectedItem;
            for (int i = inDay; i <= 31; i++) {
                bookOutInput.addItem(i);
            }
        }
    }
}
