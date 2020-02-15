package bike.simulation.tests;

import bike.simulation.Bike;
import bike.simulation.Direction;
import bike.simulation.Point;
import org.junit.Assert;
import org.junit.Test;

import static bike.simulation.Direction.*;

public class ForwardTests {
    private Bike bike;

    @Test
    public void moveForwardOneSpace_bikeNotPlaced_bikeShouldNotBePlaced()  {
        bike = new Bike();

        bike.moveForward();
        checkBikePositionAndDirection(bike.getPosition(), bike.getDirectionFacing());
    }

    @Test
    public void moveForwardOneSpace_validNorthFacingDirection_yAxisShouldIncreaseByOne() {
        bike = new Bike(new Point(3,3), NORTH);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(3,4), NORTH);
    }

    @Test
    public void moveForwardOneSpace_validSouthFacingDirection_yAxisShouldDecreaseByOne()  {
        bike = new Bike(new Point(3,3), SOUTH);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(3,2), SOUTH);
    }

    @Test
    public void moveForwardOneSpace_validEastFacingDirection_xAxisShouldIncreaseByOne()  {
        bike = new Bike(new Point(3,3), EAST);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(4,3), EAST);
    }

    @Test
    public void moveForwardOneSpace_validEastFacingDirection_xAxisShouldDecreaseByOne()  {
        bike = new Bike(new Point(3,3), WEST);

        bike.moveForward();
        checkBikePositionAndDirection(new Point(2,3), WEST);
    }


    private void checkBikePositionAndDirection(Point position, Direction direction)
    {
        Assert.assertEquals(bike.getPosition(), position);
        Assert.assertEquals(bike.getDirectionFacing(), direction);
    }
}