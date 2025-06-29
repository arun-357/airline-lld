package app.Booking;

import app.Flight;
import app.Passenger;
import app.Seat.Seat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingManager {
    private Map<String, Booking> bookings = new HashMap<>();

    public Booking createBooking(String bookingID, Flight flight, List<Passenger> passengers) {
        // check if flight is present
        Booking booking = new Booking(bookingID, flight);
        List<Seat> avialableSeats = flight.getAircraft().getAvailableSeats();
        if (avialableSeats.size() < passengers.size()) throw new RuntimeException("Not enough seats!");
        for (int i = 0; i < passengers.size(); i++) {
            booking.assignSeat(passengers.get(i), avialableSeats.get(i));
        }
        bookings.put(bookingID, booking);
        return booking;
    }

    public void cancelBookin(String BookingId) {
        Booking booking = bookings.get(BookingId);
        booking.cancelBooking();
    }
}
