package cs473;

import org.mongodb.morphia.annotations.Id;

public class Airport {
    @Id
    public String airportCode;
    public String city;
	public String state;

    public Airport(String airportCode, String city, String state) {
        this.airportCode = airportCode;
        this.city        = city;
		this.state		 = state;
    }

    public String getAirportCode() {
        return airportCode;
    }

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}
}
