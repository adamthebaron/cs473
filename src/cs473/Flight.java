package cs473;

import org.mongodb.morphia.annotations.Id;

public class Flight {
    @Id
    private String number;
    private String airline;
	private String origin;
	private String destination;
	private String plane;
	private String distance;
	private String departure;
	private String arrival;

    public Flight(String number, String airline, String origin, String destination,
				  String plane, String distance, String departure, String arrival) {
        this.number 		= number;
        this.airline        = airline;
		this.origin 		= origin;
		this.destination	= destination;
		this.plane			= plane;
		this.distance		= distance;
		this.departure		= departure;
		this.arrival		= arrival;
    }

    public String getNumber() {
        return number;
    }

	public String getAirline() {
        return airline;
    }

	public String getOrigin() {
        return origin;
    }

	public String getDestination() {
        return destination;
    }

	public String getPlane() {
        return plane;
    }

	public String getDeparture() {
        return departure;
    }

	public String getArrival() {
        return arrival;
    }

	public String getDistance() {
        return distance;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
}
