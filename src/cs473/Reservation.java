package cs473;

import org.mongodb.morphia.annotations.Id;

public class Reservation {
    @Id
    private String id;
    private String flight;
	private String traveller;
	private String seat;

    public Reservation(String id, String flight, String traveller, String seat) {
        this.id 	   = id;
        this.flight    = flight;
		this.traveller = traveller;
		this.seat	   = seat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

	public String getTraveller() {
		return traveller;
	}

	public void setTraveller(String traveller) {
		this.traveller = traveller;
	}

	public String getSeat() {
		return seat;
	}

	public void getSeat(String seat) {
		this.seat = seat;
	}
}
