package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;

public class TravellerFlight {
    @Id
	private int reservationId;
	private int flightNumber;
	private int seat;
	private int distance;
	private String from;
	private String to;
    private String airportFrom;
    private String airportTo;
	private Date start;
	private Date end;
	private String day;
	private String plane;
	private String airline;

    public TravellerFlight(int reservationId, int flightNumber, String seat, int distance,
				           String from, String to, String airportFrom, String airportTo,
                           Date start, Date end, String day, String plane, String airline) {
        this.reservationId = reservationId;
		this.flightNumber  = flightNumber;
		this.seat 		   = seat;
		this.distance	   = distance;
		this.from		   = from;
		this.to			   = to;
        this.airportFrom   = airportFrom;
        this.airportTo	   = airportTo;
		this.start		   = start;
		this.end		   = end;
		this.day		   = day;
		this.plane		   = plane;
		this.airline	   = airline;
    }
}
