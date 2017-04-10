package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;
import java.util.Map;
import java.util.Hashmap;

public class TravellerQuery {
    @Id
    private int id;
    private String name;
    private Map<Integer, TravellerFlight> flights;

    public TravellerQuery(String id, String name, Map<Integer, TravellerFlight> flights) {
        this.id 	= id;
        this.name	= name;
        this.flights = flights;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TravellerFlight getFlight(int id) {
        return flights.get(id);
    }
}
