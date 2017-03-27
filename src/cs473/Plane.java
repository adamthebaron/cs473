package cs473;

import org.mongodb.morphia.annotations.Id;

public class Plane {
    @Id
    private String airplaneCode;
    private String seats;

    public Plane(String airplaneCode, String seats) {
        this.airplaneCode = airplaneCode;
        this.seats        = seats;
    }

    public String getAirplaneCode() {
        return airplaneCode;
    }

    public void setAirplaneCode(String airplaneCode) {
        this.airplaneCode = airplaneCode;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
