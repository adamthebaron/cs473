package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;
import java.util.ArrayList;

public class AirportQuery {
    @Id
    private String airportCode;
	private String city;
	private String state;
    public int numOfFlights;

    public AirportQuery(String airportCode, String city, String state, int numOfFlights) {
        this.airportCode 	= airportCode;
        this.city	= city;
        this.state = state;
		this.numOfFlights = numOfFlights;
    }

    @Override
    public String toString() {
        return "Name: " + airportCode + " Number Of Flights: " + numOfFlights;
    }
}
