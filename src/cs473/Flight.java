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
	public Date date;

    public Flight(String number, String airline, String origin, String destination,
				  String plane, int distance, Date date) {
        this.number 		= number;
        this.airline        = airline;
		this.origin 		= origin;
		this.destination	= destination;
		this.plane			= plane;
		this.distance		= distance;
		this.date		= date;
    }
}
