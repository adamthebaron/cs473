package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;
import java.util.ArrayList;

public class TravellerFlight {
    @Id
    public int travellerId;
	public int reservationId;
	public String flightCode;
	//public boolean seat;
	public int distance;
	public String from;
	public String to;
    public String airportFrom;
    public String airportTo;
	//public Date date;
	public String day;
	public String plane;
	public String airline;

    public TravellerFlight(int travellerId, int reservationId, String flightCode, int distance,
				           String from, String to, String airportFrom, String airportTo,
                           String day, String plane, String airline) {
        this.travellerId   = travellerId;
        this.reservationId = reservationId;
		this.flightCode    = flightCode;
		this.distance	   = distance;
		this.from		   = from;
		this.to			   = to;
        this.airportFrom   = airportFrom;
        this.airportTo	   = airportTo;
		this.day		   = day;
		this.plane		   = plane;
		this.airline	   = airline;
    }

    public TravellerFlight() {
        travellerId = 0;
        reservationId = 0;
        flightCode = "";
        distance = 0;
        from = "";
        to = "";
        airportFrom = "";
        airportTo = "";
        day = "";
        plane = "";
        airline = "";
    }

    @Override
    public String toString() {
        return "Flight: " + flightCode + " From: " + from + " To: " + to + " Plane: " + plane + " Airline: " + airline;
    }
}
