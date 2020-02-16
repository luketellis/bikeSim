package bike.simulation;

public class BikeNotPlacedException extends RuntimeException {

    BikeNotPlacedException()
    {
        super("The Bike must be placed before movement or reporting");
    }
}