package app.Booking;

import app.*;
import app.Payment.PaymentProcessor;
import app.Seat.Seat;
import app.Seat.SeatStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Booking {
    private String bookingId;
    private Flight flight;
    private final Map<Passenger, Seat> seatAssignments;
    private BookingStatus status;
    private List<PaymentProcessor> payments;

    public Booking(String bookingId, Flight flight) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.seatAssignments = new HashMap<>();
        this.status = BookingStatus.CONFIRMED;
        this.payments = new ArrayList<>();
    }

    public void assignSeat(Passenger p, Seat s) {
        seatAssignments.put(p, s);
        s.setStatus(SeatStatus.BOOKED);
    }

    public double calculatePrice() {
        return seatAssignments.values().stream().mapToDouble(s -> s.getPrice(flight.getBasePrice())).sum();
    }

    public void cancelBooking() {
        status = BookingStatus.CANCELLED;
        seatAssignments.values().forEach(s -> s.setStatus(SeatStatus.AVAILABLE));
    }

    public Map<Passenger, Seat> getSeatAssignments() {
        return seatAssignments;
    }

    public void addPayments(PaymentProcessor payment) {
        this.payments.add(payment);
    }

    public List<PaymentProcessor> getPayments() {
        return payments;
    }
}
