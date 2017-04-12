package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;

public class Flight {
    @Id
    public String number;
    public String airline;
	public String origin;
	public String destination;
	public String plane;
	public int distance;
	public String dayOfWeek;

    public Flight(String number, String airline, String origin, String destination,
				  String plane, int distance, String dayOfWeek) {
        this.number 		= number;
        this.airline        = airline;
		this.origin 		= origin;
		this.destination	= destination;
		this.plane			= plane;
		this.distance		= distance;
		this.dayOfWeek		= dayOfWeek;
    }
}
