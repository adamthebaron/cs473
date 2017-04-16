package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;
import java.util.ArrayList;

public class TravellerQuery {
    @Id
    private int id;
    private String name;
    public ArrayList<TravellerFlight> flights;

    public TravellerQuery(int id, String name, ArrayList<TravellerFlight> flights) {
        this.id 	= id;
        this.name	= name;
        this.flights = flights;
    }

    public TravellerFlight getFlight(int id) {
        return flights.get(id);
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}
