package app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import app.Seat.*;

public class Aircraft {
    private String modelNo;
    private List<Seat> seats;

    public Aircraft(String modelNo, Integer economyCapacity, Integer firstClassCapacity) {
        this.modelNo = modelNo;
        this.seats = new ArrayList<>();
        int seatCounter = 1;

        // Create First Class Seats
        for (int i = 0; i < firstClassCapacity; i++) {
            String seatNumber = "F" + seatCounter++;
            seats.add(new Seat(seatNumber, SeatClass.FIRST_CLASS, new FirstClassPricing()));
        }

        seatCounter = 1; // Reset for economy

        // Create Economy Class Seats
        for (int i = 0; i < economyCapacity; i++) {
            String seatNumber = "E" + seatCounter++;
            seats.add(new Seat(seatNumber, SeatClass.ECONOMY, new EconomyPricing()));
        }
    }

    public List<Seat> getAvailableSeats() {
        return seats.stream().filter(s -> s.getStatus() != SeatStatus.BOOKED).collect(Collectors.toList());
    }

    public Seat getSeatByNumber(String seatId) {
        return seats.stream().filter(s -> s.getSeatId() == seatId).findFirst().orElse(null);
    }

    public String getModelNo() {
        return modelNo;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
