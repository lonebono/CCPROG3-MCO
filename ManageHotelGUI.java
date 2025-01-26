package MCO2.src;

import javax.swing.*;
import java.awt.*;

public class ManageHotelGUI extends JPanel {
    
    public ManageHotelGUI(){
        //Manage Hotel Panel
        setLayout(new BorderLayout());
        setBackground(Color.BLUE);

        //Manage Hotel Panel LEFT
        JPanel hotelManageList = new JPanel(new GridBagLayout());
        GridBagConstraints gbcHotelManageList = new GridBagConstraints();
        gbcHotelManageList.insets = new Insets(0, 0, 10, 0);
        hotelManageList.setPreferredSize(new Dimension(400, 600));
        add(hotelManageList, BorderLayout.WEST);

        //Selecting Hotel to Manage
        JLabel manageHotelLabel = new JLabel("Manage Hotel: ");
        gbcHotelManageList.gridx = 0; gbcHotelManageList.gridy = 0; 
        hotelManageList.add(manageHotelLabel, gbcHotelManageList);
        JComboBox manageHotels = new JComboBox<>();
        gbcHotelManageList.gridx = 1; gbcHotelManageList.gridy = 0; 
        manageHotels.setPreferredSize(new Dimension(200, 30));
        hotelManageList.add(manageHotels, gbcHotelManageList);

        //Selecting Manage Options
        JLabel manageOptionList = new JLabel("Manage Options: ");
        gbcHotelManageList.gridx = 0; gbcHotelManageList.gridy = 1; 
        hotelManageList.add(manageOptionList, gbcHotelManageList);
        JComboBox manageOptions = new JComboBox<>();
        gbcHotelManageList.gridx = 1; gbcHotelManageList.gridy = 1; 
        manageOptions.setPreferredSize(new Dimension(200, 30));
        hotelManageList.add(manageOptions, gbcHotelManageList);    

        //Manage Hotel Panel RIGHT
        JPanel hotelManageInput = new JPanel(new GridBagLayout());
        GridBagConstraints gbcHotelManageInput = new GridBagConstraints();
        gbcHotelManageInput.insets = new Insets(0, 0, 10, 0);
        hotelManageInput.setPreferredSize(new Dimension(400, 600));
        add(hotelManageInput, BorderLayout.EAST);

        //Selecting Room Type
        JLabel roomTypeList = new JLabel("Room Types: ");
        gbcHotelManageInput.gridx = 0; gbcHotelManageInput.gridy = 1; 
        hotelManageInput.add(roomTypeList, gbcHotelManageInput);
        JComboBox roomTypeOptions = new JComboBox<>();
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 1; 
        roomTypeOptions.setPreferredSize(new Dimension(200, 30));
        hotelManageInput.add(roomTypeOptions, gbcHotelManageInput);

        //Room Type Confirm Button
        JButton roomTypeButton = new JButton("Confirm");
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 2;
        gbcHotelManageInput.fill = GridBagConstraints.HORIZONTAL;
        hotelManageInput.add(roomTypeButton, gbcHotelManageInput);

        //Selecting Room to Remove
        JLabel roomRemoveList = new JLabel("   Remove Room: "); //extra space for alignment
        gbcHotelManageInput.gridx = 0; gbcHotelManageInput.gridy = 3; //change y to 1 when combobox finish for appear disappear
        hotelManageInput.add(roomRemoveList, gbcHotelManageInput);
        JComboBox roomRemove = new JComboBox<>();
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 3; //change y to 1 when combobox finish for appear disappear
        roomRemove.setPreferredSize(new Dimension(200, 30));
        hotelManageInput.add(roomRemove, gbcHotelManageInput);

        //Room Remove Remove Button
        JButton roomRemoveButton = new JButton("Remove");
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 4; //change y to 2 when combobox finish for appear disappear
        gbcHotelManageInput.fill = GridBagConstraints.HORIZONTAL;
        hotelManageInput.add(roomRemoveButton, gbcHotelManageInput);

        //Selecting Room to Update Price
        JLabel roomPriceList = new JLabel("     Update Price: ");//extra space for alignment
        gbcHotelManageInput.gridx = 0; gbcHotelManageInput.gridy = 5; //change y to 1 when combobox finish for appear disappear
        hotelManageInput.add(roomPriceList, gbcHotelManageInput);
        JComboBox roomPrice = new JComboBox<>();
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 5; //change y to 1 when combobox finish for appear disappear
        roomPrice.setPreferredSize(new Dimension(200, 30));
        hotelManageInput.add(roomPrice, gbcHotelManageInput);

        //Room Change Price Text Field
        JLabel roomPriceLabel = new JLabel("New Price:", JLabel.CENTER);
        gbcHotelManageInput.gridx = 0; gbcHotelManageInput.gridy = 6; //change y to 2 when combobox finish for appear disappear
        hotelManageInput.add(roomPriceLabel, gbcHotelManageInput);
        JTextField roomPriceInput = new JTextField(15);
        roomPriceInput.setPreferredSize(new Dimension(200, 30));
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 6; //change y to 2 when combobox finish for appear disappear
        hotelManageInput.add(roomPriceInput, gbcHotelManageInput);
        
        //Room Change Price Update Button
        JButton roomPriceButton = new JButton("Update");
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 7; //change y to 3 when combobox finish for appear disappear
        gbcHotelManageInput.fill = GridBagConstraints.HORIZONTAL;
        hotelManageInput.add(roomPriceButton, gbcHotelManageInput);

        //Selecting Reservation to Remove
        JLabel reserveRemoveList = new JLabel("Remove Reservation: ");
        gbcHotelManageInput.gridx = 0; gbcHotelManageInput.gridy = 8; //change y to 1 when combobox finish for appear disappear
        hotelManageInput.add(reserveRemoveList, gbcHotelManageInput);
        JComboBox reserveRemove = new JComboBox<>();
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 8; //change y to 1 when combobox finish for appear disappear
        reserveRemove.setPreferredSize(new Dimension(200, 30));
        hotelManageInput.add(reserveRemove, gbcHotelManageInput);

        //Reservation Remove, Remove Button
        JButton reserveRemoveButton = new JButton("Remove");
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 9; //change y to 2 when combobox finish for appear disappear
        gbcHotelManageInput.fill = GridBagConstraints.HORIZONTAL;
        hotelManageInput.add(reserveRemoveButton, gbcHotelManageInput);

        //Hotel Change Name Text Field
        JLabel hotelNameLabel = new JLabel("Change Name:", JLabel.CENTER);
        gbcHotelManageInput.gridx = 0; gbcHotelManageInput.gridy = 10; //change y to 2 when combobox finish for appear disappear
        hotelManageInput.add(hotelNameLabel, gbcHotelManageInput);
        JTextField hotelNameInput = new JTextField(15);
        hotelNameInput.setPreferredSize(new Dimension(200, 30));
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 10; //change y to 2 when combobox finish for appear disappear
        hotelManageInput.add(hotelNameInput, gbcHotelManageInput);
        
        //Hotel Change Name Change Button
        JButton hotelNameButton = new JButton("Change");
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 11; //change y to 3 when combobox finish for appear disappear
        gbcHotelManageInput.fill = GridBagConstraints.HORIZONTAL;
        hotelManageInput.add(hotelNameButton, gbcHotelManageInput);

        //Hotel Remove, Remove Button
        JButton hotelRemoveButton = new JButton("Remove");
        gbcHotelManageInput.gridx = 1; gbcHotelManageInput.gridy = 11; //change y to 3 when combobox finish for appear disappear
        gbcHotelManageInput.fill = GridBagConstraints.HORIZONTAL;
        hotelManageInput.add(hotelRemoveButton, gbcHotelManageInput);
    }
}
