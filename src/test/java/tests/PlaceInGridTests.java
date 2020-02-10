package tests;

import bike.simulation.Bike;
import bike.simulation.Direction;
import bike.simulation.Point;
import org.junit.*;

import static bike.simulation.Direction.*;

public class PlaceInGridTests {
    private Bike bike;

    @Before
    public void createNewBike()
    {
        bike = new Bike();
    }

    @Test
    public void placeInGrid_specifyNorthDirection_bikeShouldBePlacedFacingNorth()  {
        bike.placeInGrid(new Point(2,3), NORTH);
        checkBikePositionAndDirection(new Point(2,3), NORTH);
    }

    @Test
    public void placeInGrid_specifySouthDirection_bikeShouldBePlacedFacingSouth()  {
        bike.placeInGrid(new Point(2,3), SOUTH);
        checkBikePositionAndDirection(new Point(2,3), SOUTH);
    }

    @Test
    public void placeInGrid_specifyEastDirection_bikeShouldBePlacedFacingNEast()  {
        bike.placeInGrid(new Point(2,3), EAST);
        checkBikePositionAndDirection(new Point(2,3), EAST);
    }

    @Test
    public void placeInGrid_specifyWestDirection_bikeShouldBePlacedFacingWest()  {
        bike.placeInGrid(new Point(2,3), WEST);
        checkBikePositionAndDirection(new Point(2,3), WEST);
    }

    @Test
    public void placeInGrid_placeBikeAlreadyPlaced_bikeShouldUpdateToNewPlaceAndPosition()  {
        bike.placeInGrid(new Point(2,3), WEST);
        bike.placeInGrid(new Point(4,5), NORTH);

        checkBikePositionAndDirection(new Point(4,5), NORTH);
    }

    private void checkBikePositionAndDirection(Point position, Direction direction)
    {
        Assert.assertEquals(bike.getPosition(), position);
        Assert.assertEquals(bike.getDirectionFacing(), direction);
    }
}