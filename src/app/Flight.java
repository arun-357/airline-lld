package app;

import java.time.LocalDateTime;

public class Flight {
    private String flightId;
    private final String source;
    private final String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arivalTime;
    private final Aircraft aircraft;
    private double basePrice;

    public double getBasePrice() {
        return basePrice;
    }

    public Flight(String source, String destination, Aircraft aircraft, LocalDateTime departureTime, LocalDateTime arivalTime, double basePrice) {
        this.source = source;
        this.destination = destination;
        this.aircraft = aircraft;
        this.departureTime = departureTime;
        this.arivalTime = arivalTime;
        this.basePrice = basePrice;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArivalTime() {
        return arivalTime;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }
}
