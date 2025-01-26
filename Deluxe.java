package MCO2.src;

public class Deluxe extends Room {
    Deluxe(int roomNumber) {
        super(roomNumber, "Deluxe");
        this.roomType = "Deluxe";
        setPrice(getPricePerNight()); //initialises price of the room based on the base price
    }

    @Override
    public void setPrice(double newPrice) {
        super.setPrice(newPrice * 1.20); // sets 20% higher than the base price
    }

    @Override
    public double getPricePerNight() {
        return super.getPricePerNight(); // 20% more than the base price
    }
}
