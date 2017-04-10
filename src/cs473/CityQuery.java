package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;
import java.util.Map;
import java.util.Hashmap;

public class CityQuery {
    @Id
    private String name;
    private Map<Integer, CityFlight> flights;

    public CityQuery(String id, String name, Map<Integer, CityFlight> flights) {
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
