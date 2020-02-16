package bike.simulation.tests;

import bike.simulation.Bike;
import bike.simulation.Direction;
import bike.simulation.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static bike.simulation.Direction.*;

public class ForwardOutOfBoundaryTests {
    private Bike bike;

    @Before
    public void createNewBike()
    {
        bike = new Bike();
    }


    @Test
    public void moveForwardOneSpace_onExceedingMaximumNorthPosition_shouldNotChange() {
        bike.placeInGrid(new Point(6,5), NORTH);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(6,6), NORTH);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(6,6), NORTH);
    }

    @Test
    public void moveForwardOneSpace_onExceedingMaximumSouthPosition_shouldNotChange() {
        bike.placeInGrid(new Point(6,1), SOUTH);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(6,0), SOUTH);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(6,0), SOUTH);
    }

    @Test
    public void moveForwardOneSpace_onExceedingMaximumEastPosition_shouldNotChange() {
        bike.placeInGrid(new Point(5,1), EAST);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(6,1), EAST);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(6,1), EAST);
    }

    @Test
    public void moveForwardOneSpace_onExceedingMaximumWestPosition_shouldNotChange() {
        bike.placeInGrid(new Point(1,1), WEST);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(0,1), WEST);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(0,1), WEST);
    }


    private void checkBikePositionAndDirection(Point position, Direction direction)
    {
        Assert.assertEquals(bike.getPosition(), position);
        Assert.assertEquals(bike.getDirectionFacing(), direction);
    }
}