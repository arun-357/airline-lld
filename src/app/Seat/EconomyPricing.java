package app.Seat;

public class EconomyPricing implements SeatPricingStrategy {
    @Override
    public double calulatePrice(double basePrice) {
        return basePrice * 1000;
    }
}
