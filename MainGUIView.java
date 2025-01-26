package MCO2.src;

import javax.swing.*;
import java.awt.*;

//This is where the main GUI starts
//Update as soon as all functionalities are done
//Expected to have many GUI classes to adhere to MVC
//GOODLUCK
public class MainGUIView extends JFrame {
    private JLabel titleLabel;
    private JPanel titlePanel, cardPanel;
    private JPanel buttonPanel;
    private JButton btnCreate, btnView, btnManage, btnBook;

    public MainGUIView() {
        setTitle("Hotel Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setResizable(false);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Title label
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);
        titleLabel = new JLabel("Hotel Reservation System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // CardLayout panel
        cardPanel = new JPanel(new CardLayout());
        mainPanel.add(cardPanel, BorderLayout.CENTER);

        // Button panel
        buttonPanel = new JPanel();
        btnCreate = new JButton("Create Hotel");
        btnView = new JButton("View Hotel");
        btnManage = new JButton("Manage Hotel");
        btnBook = new JButton("Book Room");
        buttonPanel.add(btnCreate);
        buttonPanel.add(btnView);
        buttonPanel.add(btnManage);
        buttonPanel.add(btnBook);
        buttonPanel.setBackground(Color.BLACK);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        add(mainPanel);
    }

    public void addCard(JPanel card, String name) {
        cardPanel.add(card, name);
        System.out.println("Added card with name: " + name);
    }

    public JButton getBtnCreate() { 
        return btnCreate; 
    }
    public JButton getBtnView() { 
        return btnView; 
    }
    public JButton getBtnManage() { 
        return btnManage; 
    }
    public JButton getBtnBook() { 
        return btnBook; 
    }

    public void showCard(String name) {
        CardLayout cl = (CardLayout) (cardPanel.getLayout());
        System.out.println("Showing card with name: " + name);
        cl.show(cardPanel, name);
    }
}

