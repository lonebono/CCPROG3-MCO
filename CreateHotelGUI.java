package MCO2.src;

import javax.swing.*;
import java.awt.*;

public class CreateHotelGUI extends JPanel{
    private JTextArea createTextInfo;
    private JTextField inputFeedback, inputHotelName, createRoomType;
    private JButton createHotelSubmit;

    // Hotel Creation Panel
    public CreateHotelGUI(){
        setLayout(new BorderLayout());
        JPanel createList = new JPanel(new GridBagLayout());
        JPanel createInput = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCreateList = new GridBagConstraints();
        gbcCreateList.insets = new Insets(0, 0, 10, 0); // Padding // top left bot right
        gbcCreateList.fill = GridBagConstraints.BOTH; // Fill horizontally and vertically
        GridBagConstraints gbcCreateInput = new GridBagConstraints();
        gbcCreateInput.insets = new Insets(0, 0, 10, 0);

        setBackground(Color.GRAY);
        //createList
        createList.setPreferredSize(new Dimension(400, 600));
        add(createList, BorderLayout.WEST);
        JLabel createLabelInfo = new JLabel("Hotel List Info", JLabel.CENTER);
        gbcCreateList.gridx = 0; gbcCreateList.gridy = 0; gbcCreateList.weightx = 0.05; gbcCreateList.weighty = 0.05; 
        createList.add(createLabelInfo, gbcCreateList); // adds the label
        createTextInfo = new JTextArea();
        createTextInfo.setEditable(false);
        createTextInfo.setLineWrap(true);
        JScrollPane infoScroll = new JScrollPane(createTextInfo); // Wrap text field in scroll pane
        infoScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        infoScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        gbcCreateList.gridx = 0; gbcCreateList.gridy = 1; gbcCreateList.weightx = 0.3; gbcCreateList.weighty = 0.3;
        createList.add(infoScroll, gbcCreateList); // adds the info list
        //createInput
        createInput.setPreferredSize(new Dimension(400,600));
        add(createInput, BorderLayout.EAST);
        JLabel createFeedbackLabel= new JLabel("Feedback:", JLabel.CENTER);
        gbcCreateInput.gridx = 0; gbcCreateInput.gridy = 0;
        createInput.add(createFeedbackLabel, gbcCreateInput);
        inputFeedback = new JTextField(15);
        inputFeedback.setEditable(false);
        gbcCreateInput.gridx = 1; gbcCreateInput.gridy = 0;
        createInput.add(inputFeedback, gbcCreateInput);
        JLabel inputHotelLabel = new JLabel("Hotel Name:", JLabel.CENTER);
        gbcCreateInput.gridx = 0; gbcCreateInput.gridy = 1; 
        createInput.add(inputHotelLabel, gbcCreateInput);
        inputHotelName = new JTextField(15);
        gbcCreateInput.gridx = 1; gbcCreateInput.gridy = 1;
        createInput.add(inputHotelName, gbcCreateInput);
        JLabel createRoomLabel = new JLabel("Room Type:", JLabel.CENTER);
        gbcCreateInput.gridx = 0; gbcCreateInput.gridy = 2;
        createInput.add(createRoomLabel, gbcCreateInput);
        createRoomType = new JTextField(15);
        gbcCreateInput.gridx = 1; gbcCreateInput.gridy = 2;
        createInput.add(createRoomType, gbcCreateInput);
        createHotelSubmit = new JButton("Submit");
        gbcCreateInput.gridx = 0; gbcCreateInput.gridy = 3; gbcCreateInput.gridwidth = 2;
        createInput.add(createHotelSubmit, gbcCreateInput);
        }

        public JTextArea getCreateTextInfo() {
            return createTextInfo;
        }
        
        public JTextField getInputFeedback() {
            return inputFeedback;
        }
        
        public JTextField getInputHotelName() {
            return inputHotelName;
        }
        
        public JTextField getCreateRoomType() {
            return createRoomType;
        }
        
        public JButton getCreateHotelSubmit() {
            return createHotelSubmit;
        }
}
