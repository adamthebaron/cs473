package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class CityQuery {
    @Id
    private String name;
    private Map<Integer, CityFlight> flights;

    public CityQuery(String name, Map<Integer, CityFlight> flights) {
        this.name	= name;
        this.flights = flights;
    }

    public CityFlight getFlight(int id) {
        return flights.get(id);
    }
}
