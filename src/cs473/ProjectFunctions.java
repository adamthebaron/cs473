package cs473;

import org.mongodb.morphia.Datastore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// This is the class that you will need to modify in order to make our application work.
public class ProjectFunctions {
    private final Datastore datastore;

    public ProjectFunctions(Datastore datastore) {
        this.datastore = datastore;
    }

    public final Map<String, String> airlines = new HashMap<>();
    public final Map<String, Airport> airports = new HashMap<>();
    public final Map<String, Flight> flights = new HashMap<>();
    public final Map<String, Integer> planes = new HashMap<>();
    public final Map<Integer, Reservation> reservations = new HashMap<>();
    public final Map<Integer, String> travelers = new HashMap<>();

    public int getSeatsTaken(String flight) {
        int seatsTaken = 0;
        for (Reservation reservation: reservations.values())
            if (flight.equals(reservation.flight))
                seatsTaken++;
        return seatsTaken;
    }

    public String getDay(int day) {
        switch(day) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return "Day not found.";
        }
    }

    public String getAirportState(String airport) {
        Airport curAirport = airports.get(airport);
        return curAirport.city;
    }

    public Date getFlightDate(String flightCode) {
        for (Reservation reservation: reservations.values())
            if(flightCode.equals(reservation.flight))
                return reservation.date;
        return null;
    }

    public void addAirline(String airlineCode, String name) {
        System.out.println(String.format("Adding airline %s\t%s", airlineCode, name));
        Airline airline = new Airline(airlineCode, name);
        airlines.put(airlineCode, name);
    }

    public void addAirport(String airportCode, String state, String city) {
        System.out.println(String.format("Adding airport %s\t%s\t%s", airportCode, state, city));
        Airport airport = new Airport(airportCode, city, state);
        airports.put(airportCode, airport);
    }

    public void addPlane(String planeType, int seats) {
        System.out.println(String.format("Adding plane %s\t%d seats", planeType, seats));
        Plane plane = new Plane(planeType, Integer.toString(seats));
	    planes.put(planeType, seats);
    }

    public void addFlight(String airlineCode, String flightCode, int dayOfWeek, String origAirportCode, String destAirportCode, String planeType) {
        System.out.println(String.format("Adding flight %s\tfrom %s to %s on %d\tplane %s", flightCode, origAirportCode, destAirportCode, dayOfWeek, planeType));
        Flight flight = new Flight(flightCode, airlineCode, origAirportCode, destAirportCode, planeType, 0, getFlightDate(flightCode));
	    flights.put(flightCode, flight);
        FlightQuery flightQuery = new FlightQuery(flightCode, airlineCode, origAirportCode, getAirportState(origAirportCode),
                                                  destAirportCode, getAirportState(destAirportCode),
                                                  planeType, planes.get(planeType), getSeatsTaken(flightCode),
                                                  getFlightDate(flightCode), 0, getDay(dayOfWeek));
        datastore.save(flightQuery);
    }

    public void addTraveler(int travelerId, String name) {
        System.out.println(String.format("Adding traveller %d\t%s", travelerId, name));
        //TravellerQuery travellerQuery = new TravellerQuery();
	    travelers.put(travelerId, name);
        //datastore.save(traveler);
    }

    public void makeReservation(int reservationId, int travelerId, String flightCode, int dayOfWeek, Date date) {
        System.out.println(String.format("Making reservation %d for traveller %d on flight %s for the date %s", reservationId, travelerId, flightCode, date.toString()));
        Reservation reservation = new Reservation(reservationId, flightCode, travelerId, dayOfWeek, 0, date);
	    reservations.put(reservationId, reservation);
        datastore.save(reservation);
    }
}
