package bike.simulation.tests;

import bike.simulation.Bike;
import bike.simulation.BikeNotPlacedException;
import bike.simulation.Direction;
import bike.simulation.Point;
import org.junit.Assert;
import org.junit.Test;

import static bike.simulation.Direction.*;

public class TurnRightTests {
    private Bike bike;

    @Test(expected = BikeNotPlacedException.class)
    public void turnRight_bikeNotPlaced_bikeShouldNotHavePositionOrDirection() {
        bike = new Bike();

        bike.turnRight();
        checkBikePositionAndDirection(bike.getPosition(), bike.getDirectionFacing());
    }

    @Test
    public void turnRight_bikeHasNorthPosition_bikeShouldFaceEast() {
        bike = new Bike(new Point(0,0), NORTH);

        bike.turnRight();
        checkBikePositionAndDirection(new Point(0,0), EAST);
    }

    @Test
    public void turnRight_bikeHasSouthPosition_bikeShouldFaceWest() {
        bike = new Bike(new Point(0,0), SOUTH);

        bike.turnRight();
        checkBikePositionAndDirection(new Point(0,0), WEST);
    }

    @Test
    public void turnRight_bikeHasEastPosition_bikeShouldFaceSouth() {
        bike = new Bike(new Point(0,0), EAST);

        bike.turnRight();
        checkBikePositionAndDirection(new Point(0,0), SOUTH);
    }

    @Test
    public void turnRight_bikeHasWestPosition_bikeShouldFaceNorth() {
        bike = new Bike(new Point(0,0), WEST);

        bike.turnRight();
        checkBikePositionAndDirection(new Point(0,0), NORTH);
    }


    private void checkBikePositionAndDirection(Point position, Direction direction)
    {
        Assert.assertEquals(bike.getPosition(), position);
        Assert.assertEquals(bike.getDirectionFacing(), direction);
    }
}