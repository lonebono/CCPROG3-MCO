package MCO2.src;

public class Executive extends Room {
    Executive(int roomNumber) {
        super(roomNumber, "Executive");
        this.roomType = "Executive";
        setPrice(getPricePerNight()); //initialises price of the room based on the base price
    }

    @Override
    public void setPrice(double newPrice) {
        super.setPrice(newPrice * 1.35); // sets 35% higher than the base price
    }

    @Override
    public double getPricePerNight() {
        return super.getPricePerNight(); // 35% more than the base price
    }
}
