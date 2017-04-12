package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class TravellerQuery {
    @Id
    private int id;
    private String name;
    public TravellerFlight flights[];

    public TravellerQuery(int id, String name, TravellerFlight flights[]) {
        this.id 	= id;
        this.name	= name;
        this.flights = flights;
    }

    public TravellerFlight getFlight(int id) {
        return flights.get(id);
    }
}
