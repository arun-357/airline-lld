package app.Seat;

public class Seat {
    private String seatId;
    private SeatStatus status;
    private SeatClass seatClass;
    private SeatPricingStrategy seatPricingStrategy;

    public Seat(String seatId, SeatClass seatClass, SeatPricingStrategy pricingStrategy) {
        this.seatId = seatId;
        this.status = SeatStatus.AVAILABLE;
        this.seatClass = seatClass;
        this.seatPricingStrategy = pricingStrategy;
    }

    public String getSeatId() {
        return seatId;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public double getPrice(double basePrice) {
        return seatPricingStrategy.calulatePrice(basePrice);
    }
}
