package app.Seat;

public class FirstClassPricing implements SeatPricingStrategy {
    @Override
    public double calulatePrice(double basePrice) {
        return basePrice * 5000;
    }
}
