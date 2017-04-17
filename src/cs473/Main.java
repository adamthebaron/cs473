package cs473;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
//import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger("org.mongodb");
        mongoLogger.setLevel(Level.SEVERE);
        /*// Create the Morphia instance through which all access to Mongo is going to occur
        final Morphia morphia = new Morphia();

        // Tell Morphia where to find the mapping classes
        morphia.mapPackage("cs473");

        // Create the datastore, providing the actual connetion to the Mongo database instance. Every project team
        // should use a different dbName instead of travel473. This line of code will change slightly when we start
        // connecting to a replica set, but it will be the only code that will have to change. For now get your app
        // running connecting to a single instance of mongo.
        String uriString    = args[0];
        String databaseName = args[1];
        String dataFile     = args[2];

        String actualURI = String.format(uriString);
        MongoClientURI uri = new MongoClientURI(actualURI);
        final Datastore datastore = morphia.createDatastore(new MongoClient(uri), databaseName);


        // Create the ProjectFunctions class
        final ProjectFunctions projectFunctions = new ProjectFunctions(datastore);
        final QueryFunctions queryFunctions = new QueryFunctions(datastore);


        // Run this function to load data, comment it out if you are querying data
        loadFile(projectFunctions, dataFile);
        */
        //MogoClientURI uri = new MongoClientURI("mongodb://cs473:ButlerDawgz@cs473-shard-00-00-7choh.mongodb.net:37012/garpon?ssl=true&authSource=admin");
        //final Datastore datastore = morphia.createDatastore(new MongoClient(uri), "garpon");

        // Create the Morphia instance through which all access to Mongo is going to occur
        final Morphia morphia = new Morphia();

        // Tell Morphia where to find the mapping classes
        morphia.mapPackage("cs473");

        // Create the datastore, providing the actual connetion to the Mongo database instance. Every project team
        // should use a different dbName instead of travel473. This line of code will change slightly when we start
        // connecting to a replica set, but it will be the only code that will have to change. For now get your app
        // running connecting to a single instance of mongo.
        final Datastore datastore = morphia.createDatastore(new MongoClient(args[0], 27017), "garpon4");

        // Create the ProjectFunctions class
        final ProjectFunctions projectFunctions = new ProjectFunctions(datastore);
        final QueryFunctions queryFunctions = new QueryFunctions(datastore);

        Scanner scanner = new Scanner(System.in);

        // Now load the file
        String fileName = args[1];

        //read file into stream, try-with-resources
        /*try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> {
                String[] splits = line.split(",");
                switch(splits[0]) {
                    case "AIRLINE":
                        projectFunctions.addAirline(splits[1].trim(), splits[2].trim());
                        break;
                    case "AIRPORT":
                        projectFunctions.addAirport(splits[1].trim(), splits[2].trim(), splits[3].trim());
                        break;
                    case "PLANE":
                        projectFunctions.addPlane(splits[1].trim(), Integer.parseInt(splits[2].trim()));
                        break;
                    case "FLIGHT":
                        projectFunctions.addFlight(splits[1].trim(), splits[2].trim(), Integer.parseInt(splits[3].trim()), splits[4].trim(), splits[5].trim(), splits[6].trim());
                        break;
                    case "TRAVELER":
                        projectFunctions.addTraveler(Integer.parseInt(splits[1].trim()), splits[2].trim());
                        break;
                    case "RESERVATION":
                        projectFunctions.makeReservation(Integer.parseInt(splits[1].trim()), Integer.parseInt(splits[2].trim()), splits[3].trim(), Integer.parseInt(splits[4].trim()), Date.valueOf(splits[5].trim()));
                        break;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
                Thread.sleep(5000);
        } catch(InterruptedException ex) { }
        System.out.println("Executing Queries");
        // 1
        System.out.println("flightAvailability();");
        System.out.println("Returns all flights between the two airports on a given date. Note that I have simplified this from the");
        System.out.println("original requirements that specified a date range.  This function returns a generic Object so you can return");
        System.out.println("any object type that makes sense for your data model. The class your return should override the toString() method");
        System.out.println("and print something useful. Look at the sample Airline object for an example of this.");
        System.out.print("Enter origin airport: ");
        String originAirport = scanner.next();
        System.out.print("Enter destination airport: ");
        String destinationAirport = scanner.next();
        System.out.print("Using current day of week:  ");
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        System.out.println(dateFormat.format(now));
        List<FlightQuery> flightsavailable = queryFunctions.flightAvailability(originAirport, destinationAirport, now);
        System.out.println("Num of flights: " + flightsavailable.size());
        for (FlightQuery flight: flightsavailable) {
            System.out.println(flight.toString());
        }
        // 2
        System.out.println("flightOverbooked();");
        System.out.println("Returns all flights that are overbooked on the given day at the airport in question. If the boolean");
        System.out.println("checkOriginationCity is true, then you should check flights leaving the airport on the day. If the value is");
        System.out.println("false then you should check flight arriving at the airport that day. I have simplified this to a single date");
        System.out.println("instead of a date range.");
        System.out.print("Use from or to: ");
        boolean checkOriginationCity = scanner.nextBoolean();
        System.out.print("Enter airport code: ");
        String overbookedAirport = scanner.next();
        System.out.print("Using current day of week: ");
        System.out.println(dateFormat.format(now));
        List<FlightQuery> flightsOverbooked = queryFunctions.flightOverbooked(checkOriginationCity, overbookedAirport, now);
        System.out.println("Num of flights: " + flightsOverbooked.size());
        for (FlightQuery flight: flightsOverbooked) {
            System.out.println(flight.toString());
        }
    }
}
