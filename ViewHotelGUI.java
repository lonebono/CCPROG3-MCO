package MCO2.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewHotelGUI extends JPanel {
    private GUIController guiController;
    private JComboBox<String> viewHotels;
    private JButton highLevel;
    private JButton lowLevel;
    private JComboBox<String> lowOptions;
    private JComboBox<String> viewDate;
    private JComboBox<String> viewRoom;
    private JComboBox<String> viewReserve;
    private JTextArea viewHotelInfo;

    public ViewHotelGUI() {
        this.guiController = guiController;
        // View Hotel Panel
        setLayout(new BorderLayout());
        setBackground(Color.GREEN);

        // View Hotel Panel LEFT
        JPanel hotelViewList = new JPanel(new GridBagLayout());
        GridBagConstraints gbcHotelViewList = new GridBagConstraints();
        gbcHotelViewList.insets = new Insets(0, 0, 10, 0);
        hotelViewList.setPreferredSize(new Dimension(400, 600));
        add(hotelViewList, BorderLayout.WEST);

        // View Hotel Panel RIGHT
        JPanel hotelViewInput = new JPanel(new GridBagLayout());
        GridBagConstraints gbcHotelViewInput = new GridBagConstraints();
        gbcHotelViewInput.insets = new Insets(0, 0, 10, 0);
        hotelViewInput.setPreferredSize(new Dimension(400, 600));
        add(hotelViewInput, BorderLayout.EAST);

        // Selecting Hotel to View
        JLabel viewHotelLabel = new JLabel("Select Hotel: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 0;
        hotelViewList.add(viewHotelLabel, gbcHotelViewList);
        viewHotels = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 0;
        viewHotels.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(viewHotels, gbcHotelViewList);

        // High-Level Button
        highLevel = new JButton("High-Level");
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 1;
        gbcHotelViewList.fill = GridBagConstraints.HORIZONTAL;
        hotelViewList.add(highLevel, gbcHotelViewList);

        // Low-Level Button
        lowLevel = new JButton("Low-Level");
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 2;
        gbcHotelViewList.fill = GridBagConstraints.HORIZONTAL;
        hotelViewList.add(lowLevel, gbcHotelViewList);

        viewHotelInfo = new JTextArea(100, 20);
        viewHotelInfo.setEditable(false);
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 3;
        gbcHotelViewList.fill = GridBagConstraints.HORIZONTAL;
        hotelViewList.add(viewHotelInfo, gbcHotelViewList);

        // Selecting low-level type of information
        JLabel lowLevelOption = new JLabel("Low-Level Options: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 3;
        hotelViewList.add(lowLevelOption, gbcHotelViewList);
        lowOptions = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 3;
        lowOptions.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(lowOptions, gbcHotelViewList);

        // Low-Level Info View Rooms for Date
        JLabel hotelViewDate = new JLabel("Select a Date: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 4;
        hotelViewList.add(hotelViewDate, gbcHotelViewList);
        viewDate = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 4;
        viewDate.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(viewDate, gbcHotelViewList);

        // Low-Level Info View Rooms Info
        JLabel roomViewInfo = new JLabel("Select a Room: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 5;
        hotelViewList.add(roomViewInfo, gbcHotelViewList);
        viewRoom = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 5;
        viewRoom.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(viewRoom, gbcHotelViewList);

        // Low-Level Info View Reservation Info
        JLabel reservationViewInfo = new JLabel("Select a Reservation: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 6;
        hotelViewList.add(reservationViewInfo, gbcHotelViewList);
        viewReserve = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 6;
        viewReserve.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(viewReserve, gbcHotelViewList);

        // Add action listeners
        viewHotels.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedHotel = (String) viewHotels.getSelectedItem();
                if (selectedHotel!= null) {
                    guiController.updateViewHotelView(selectedHotel);
                }
            }
        });

        lowLevel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) lowOptions.getSelectedItem();
                if (selectedOption != null) {
                }
            }
        });

    }

public void setGuiController(GUIController guiController) {
    this.guiController = guiController;
}

    // Getters for the components
    public JComboBox<String> getViewHotels() {
        return viewHotels;
    }

    public JButton getHighLevelButton() {
        return highLevel;
    }

    public JButton getLowLevelButton() {
        return lowLevel;
    }

    public JTextArea getViewHotelInfo() {
        return viewHotelInfo;
    }
    
    public JComboBox<String> getLowOptions() {
        return lowOptions;
    }

    public JComboBox<String> getViewDate() {
        return viewDate;
    }

    public JComboBox<String> getViewRoom() {
        return viewRoom;
    }

    public JComboBox<String> getViewReserve() {
        return viewReserve;
    }

    // Placeholder for method to update the view based on the selected hotel
    private void updateViewHotelView(String selectedHotel) {
        // Implementation to update the view based on the selected hotel
        // This might involve querying a database or updating the JComboBoxes with relevant data
    }
}