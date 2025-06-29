import app.*;
import app.Booking.Booking;
import app.Booking.BookingManager;
import app.Payment.PaymentProcessor;
import app.Payment.PaymentStartegy;
import app.Payment.UPI;
import app.Seat.Seat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("Boieng", 10, 1);
        Flight flight = new Flight("India", "USA", aircraft, LocalDateTime.now(), LocalDateTime.now(), 100);

        Passenger arun = new Passenger("p1", "Arun", "arun@email.com");
        Passenger dev = new Passenger("p1", "Dev", "dev@email.com");

        BookingManager manager = new BookingManager();
        Booking booking = manager.createBooking("b1", flight,  Arrays.asList(arun, dev));

        System.out.println("Booking Successful. Seat Assignments:");
        for (Map.Entry<Passenger, Seat> entry : booking.getSeatAssignments().entrySet()) {
            System.out.println(entry.getKey().getName() + " -> Seat: " + entry.getValue().getSeatId()
                    + " | Class: " + entry.getValue().getSeatClass()
                    + " | Price: ₹" + entry.getValue().getPrice(flight.getBasePrice()));
        }

        double totalAmount = booking.calculatePrice();
        PaymentStartegy UPI = new UPI("arun@upi");
        PaymentProcessor paymentProcessor = new PaymentProcessor("1", UPI);
        paymentProcessor.process(totalAmount);
        booking.addPayments(paymentProcessor);
    }
}