package cs473;

import org.mongodb.morphia.annotations.Id;
import java.util.Date;

public class Reservation {
    @Id
    public int id;
    public String flight;
	public int traveller;
	public int dayOfWeek;
    public int seat;
    public Date date;

    public Reservation(int id, String flight, int traveller, int dayOfWeek, int seat, Date date) {
        this.id 	   = id;
        this.flight    = flight;
		this.traveller = traveller;
        this.dayOfWeek = dayOfWeek;
        this.seat = seat;
        this.date      = date;
    }
}
