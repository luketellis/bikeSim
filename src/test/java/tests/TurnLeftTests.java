package tests;

import bike.simulation.Bike;
import bike.simulation.Direction;
import bike.simulation.Point;
import org.junit.*;

import static bike.simulation.Direction.*;

public class TurnLeftTests {
    private Bike bike;

    @Test
    public void turnLeft_bikeNotPlaced_bikeShouldNotHavePositionOrDirection()  {
        bike = new Bike();

        bike.turnLeft();
        checkBikePositionAndDirection(bike.getPosition(), bike.getDirectionFacing());
    }

    @Test
    public void turnLeft_bikeHasNorthPosition_bikeShouldFaceWest()  {
        bike = new Bike(new Point(0,0), NORTH);

        bike.turnLeft();
        checkBikePositionAndDirection(new Point(0,0), WEST);
    }

    @Test
    public void turnLeft_bikeHasSouthPosition_bikeShouldFaceEast()  {
        bike = new Bike(new Point(0,0), SOUTH);

        bike.turnLeft();
        checkBikePositionAndDirection(new Point(0,0), EAST);
    }

    @Test
    public void turnLeft_bikeHaEastPosition_bikeShouldFaceNorth()  {
        bike = new Bike(new Point(0,0), EAST);

        bike.turnLeft();
        checkBikePositionAndDirection(new Point(0,0), NORTH);
    }

    @Test
    public void turnLeft_bikeHasWestPosition_bikeShouldFaceSouth()  {
        bike = new Bike(new Point(0,0), WEST);

        bike.turnLeft();
        checkBikePositionAndDirection(new Point(0,0), SOUTH);
    }


    private void checkBikePositionAndDirection(Point position, Direction direction)
    {
        Assert.assertEquals(bike.getPosition(), position);
        Assert.assertEquals(bike.getDirectionFacing(), direction);
    }
}