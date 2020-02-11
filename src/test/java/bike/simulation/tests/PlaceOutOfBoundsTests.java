package bike.simulation.tests;

import bike.simulation.Bike;
import bike.simulation.Direction;
import bike.simulation.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static bike.simulation.Direction.*;

public class PlaceOutOfBoundsTests {
    private Bike bike;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void createNewBike()
    {
        bike = new Bike();
    }


    @Test
    public void placeInGrid_xCoordinateExceedsLimit_bikeShouldNotBePlaced() {
        bike.placeInGrid(new Point(100,1), NORTH);
        checkBikePositionAndDirection(null, null);
    }

    @Test
    public void placeInGrid_xCoordinateUpperBoundary_bikeShouldOnlyBeSetAtXMaximumValue() {
        bike.placeInGrid(new Point(7,1), NORTH);
        checkBikePositionAndDirection(null, null);

        bike.placeInGrid(new Point(6,1), NORTH);
        checkBikePositionAndDirection(new Point(6,1), NORTH);
    }

    @Test
    public void placeInGrid_xCoordinateLowerBoundary_bikeShouldOnlyBeSetAtXMinimumValue() {
        bike.placeInGrid(new Point(-1,1), SOUTH);
        checkBikePositionAndDirection(null, null);

        bike.placeInGrid(new Point(0,1), SOUTH);
        checkBikePositionAndDirection(new Point(0,1), SOUTH);
    }

    @Test
    public void placeInGrid_xCoordinateLowerBoundaryExceeded_bikeShouldNotBePlaced() {
        bike.placeInGrid(new Point(-10,1), SOUTH);
        checkBikePositionAndDirection(null, null);
    }

    @Test
    public void placeInGrid_yCoordinateLowerBoundaryExceeded_bikeShouldNotBePlaced()  {
        bike.placeInGrid(new Point(1,-100), SOUTH);
        checkBikePositionAndDirection(null, null);
    }

    @Test
    public void placeInGrid_yCoordinateUpperBoundaryExceeded_bikeShouldNotBePlaced() {
        bike.placeInGrid(new Point(1,100), NORTH);
        checkBikePositionAndDirection(null, null);
    }

    @Test
    public void placeInGrid_yCoordinateUpperBoundary_bikeShouldOnlyBeSetAtYMaximumValue() {
        bike.placeInGrid(new Point(1,7), NORTH);
        checkBikePositionAndDirection(null, null);

        bike.placeInGrid(new Point(1,6), NORTH);
        checkBikePositionAndDirection(new Point(1,6), Direction.NORTH);
    }

    @Test
    public void placeInGrid_yCoordinateLowerBoundary_bikeShouldOnlyBeSetAtYMinimumValue() {
        bike.placeInGrid(new Point(1,-1), SOUTH);
        checkBikePositionAndDirection(null, null);

        bike.placeInGrid(new Point(1,0), SOUTH);
        checkBikePositionAndDirection(new Point(1,0), SOUTH);
    }

    @Test
    public void placeInGrid_xAndYCoordinateUpperBoundaryExceeded_bikeShouldNotBePlaced() {
        bike.placeInGrid(new Point(100,100), SOUTH);
        checkBikePositionAndDirection(null, null);
    }

    @Test
    public void placeInGrid_xAndYCoordinateLowerBoundaryExceeded_bikeShouldNotBePlaced()  {
        bike.placeInGrid(new Point(-100,-100), SOUTH);
        checkBikePositionAndDirection(null, null);
    }


    private void checkBikePositionAndDirection(Point position, Direction direction)
    {
        Assert.assertEquals(bike.getPosition(), position);
        Assert.assertEquals(bike.getDirectionFacing(), direction);
    }
}