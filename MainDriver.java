package MCO2.src;

public class MainDriver {
    public static void main(String[] args) {
        // Create instances of the view and model
        MainGUIView view = new MainGUIView();
        ReserveSystem reserveSystem = new ReserveSystem();

        // Create instances of the GUI components
        CreateHotelGUI createHotelGUI = new CreateHotelGUI();
        ViewHotelGUI viewHotelGUI = new ViewHotelGUI();
        ManageHotelGUI manageHotelGUI = new ManageHotelGUI();
        BookRoomGUI bookRoomGUI = new BookRoomGUI(reserveSystem);

        // Create the controller and pass the view, model, and GUI components
        GUIController controller = new GUIController(view, reserveSystem, createHotelGUI, viewHotelGUI, manageHotelGUI, bookRoomGUI);

        // Set the GUIController object in the ViewHotelGUI object
        viewHotelGUI.setGuiController(controller);

        // Make the main view visible
        view.setVisible(true);
    }
}
