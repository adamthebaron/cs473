package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;

public class FlightResult {
    @Id
    public String className;
    public String number;
    public String airline;
    public String from;
    public String fromAirport;
	public String to;
    public String toAirport;
	public String airplane;
	public int seats;
	//public int seatsTaken;
	public Date date;
	public int distance;
	public String day;

    public FlightResult(String className, String number, String airline, String from, String fromAirport, String to, String toAirport, String airplane,
					   int seats, Date date, int distance, String day) {
        this.className = className;
        this. number 	= number;
        this.airline	= airline;
        this.from = from;
        this.fromAirport = fromAirport;
		this.to = to;
        this.toAirport = toAirport;
		this.airplane = airplane;
		this.seats = seats;
		this.date = date;
		this.distance = distance;
		this.day = day;
    }

    @Override
    public String toString() {
        return "Flight number: " + number + " From: " + from + "To: " + to + " Airplane: " + airplane;
    }
}
