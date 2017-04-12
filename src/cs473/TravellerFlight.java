package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;

public class TravellerFlight {
    @Id
    public int travellerId;
	public int reservationId;
	public int flightNumber;
	public boolean seat;
	public int distance;
	public String from;
	public String to;
    public String airportFrom;
    public String airportTo;
	//public Date date;
	public String day;
	public String plane;
	public String airline;

    public TravellerFlight(int travellerId, int reservationId, int flightNumber, int distance,
				           String from, String to, String airportFrom, String airportTo,
                           String day, String plane, String airline) {
        this.travellerId   = travellerId;
        this.reservationId = reservationId;
		this.flightNumber  = flightNumber;
		this.distance	   = distance;
		this.from		   = from;
		this.to			   = to;
        this.airportFrom   = airportFrom;
        this.airportTo	   = airportTo;
		this.day		   = day;
		this.plane		   = plane;
		this.airline	   = airline;
    }
}
