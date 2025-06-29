package app;

public class Passenger {
    private final String id;
    private final String name;
    private final String email;

    public Passenger(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
}
