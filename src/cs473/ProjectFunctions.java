package cs473;

import org.mongodb.morphia.Datastore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

// This is the class that you will need to modify in order to make our application work.

//order data must be imported:
// 1: flights
// 2: reservations
// 3: travelers
// 2: airports
// 4: airlines
// 5: airplanes
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
    public ArrayList<FlightQuery> flightQueries = new ArrayList<>();
    public ArrayList<TravellerQuery> travellerQueries = new ArrayList<>();
    public ArrayList<TravellerFlight> travellerFlights = new ArrayList<>();
    public ArrayList<AirportQuery> airportQueries = new ArrayList<>();

    public int getSeatsTaken(String flight) {
        int seatsTaken = 0;
        for (Reservation reservation: reservations.values())
            if (flight.equals(reservation.flight))
                seatsTaken++;
        return seatsTaken;
    }

    public int getNumOfReservations(String airportCode) {
        int reservations = 0;
        for (Flight flight: flights.values()) {
            if (airportCode.equals(flight.origin))
                reservations++;
            else if (airportCode.equals(flight.destination))
                reservations++;
        }
        return reservations;
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

    public String getAirportCity(String airport) {
        Airport curAirport = airports.get(airport);
        return curAirport.city;
    }

    public Date getFlightDate(String flightCode) {
        for (Reservation reservation: reservations.values())
            if(flightCode.equals(reservation.flight))
                return reservation.date;
        return null;
    }

    public Flight getFlight(String flightCode) {
        for (Flight flight: flights.values())
            if (flightCode.equals(flight.number))
                return flight;
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
        AirportQuery airportQuery = new AirportQuery(airportCode, city, state, getNumOfReservations(airportCode));
        airportQueries.add(airportQuery);
        datastore.save(airportQuery);
    }

    public void addPlane(String planeType, int seats) {
        System.out.println(String.format("Adding plane %s\t%d seats", planeType, seats));
        Plane plane = new Plane(planeType, Integer.toString(seats));
	    planes.put(planeType, seats);
    }

    public void addFlight(String airlineCode, String flightCode, int dayOfWeek, String origAirportCode, String destAirportCode, String planeType) {
        System.out.println(String.format("Adding flight %s\tfrom %s to %s on %d\tplane %s", flightCode, origAirportCode, destAirportCode, dayOfWeek, planeType));
        Flight flight = new Flight(flightCode, airlineCode, origAirportCode, destAirportCode, planeType, 0, getDay(dayOfWeek));
	    flights.put(flightCode, flight);
        FlightQuery flightQuery = new FlightQuery(flightCode, airlineCode, getAirportCity(origAirportCode), origAirportCode,
                                                  getAirportCity(destAirportCode), destAirportCode,
                                                  planeType, planes.get(planeType),
                                                  0, getDay(dayOfWeek));
        datastore.save(flightQuery);
        flightQueries.add(flightQuery);
    }

    public void addTraveler(int travelerId, String name) {
        System.out.println(String.format("Adding traveller %d\t%s", travelerId, name));
        ArrayList<TravellerFlight> localFlights = new ArrayList<>();
        for (TravellerFlight flight: travellerFlights)
            if (travelerId == flight.travellerId)
                localFlights.add(flight);
        TravellerQuery travellerQuery = new TravellerQuery(travelerId, name, localFlights);
	    travelers.put(travelerId, name);
        datastore.save(travellerQuery);
        travellerQueries.add(travellerQuery);
    }

    public void makeReservation(int reservationId, int travelerId, String flightCode, int dayOfWeek, Date date) {
        System.out.println(String.format("Making reservation %d for traveller %d on flight %s for the date %s", reservationId, travelerId, flightCode, date.toString()));
        Reservation reservation = new Reservation(reservationId, flightCode, travelerId, dayOfWeek, 0, date);
	    reservations.put(reservationId, reservation);
        //datastore.save(reservation);
        Flight flight = getFlight(flightCode);
        travellerFlights.add(new TravellerFlight(travelerId, reservationId, flightCode, 0, getAirportCity(flight.origin),
                                                              getAirportCity(flight.destination), flight.origin, flight.destination,
                                                              flight.dayOfWeek, flight.plane, flight.airline));
    }
}
