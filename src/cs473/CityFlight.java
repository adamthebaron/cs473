package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;

public class CityFlight {
    @Id
	private String number;
	private String airport;
	private String to;
	private String airportTo;
	private String airline;
	private String airplane;
	private int seats;
	private int seatsTaken;
	private Date start;
	private Date end;
	private String day;

    public CityFlight(int reservationId, int flightNumber, String seat, int distance,
				  String from, String to, String airportTo, Date start, Date end, String day,
				  String plane, String airline) {
        this.reservationId = reservationId;
		this.flightNumber  = flightNumber;
		this.seat 		   = seat;
		this.distance	   = distance;
		this.from		   = from;
		this.to			   = to;
		this.airportTo	   = airportTo;
		this.start		   = start;
		this.end		   = end;
		this.day		   = day;
		this.plane		   = plane;
		this.airline	   = airline;
    }
}
