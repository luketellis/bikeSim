package bike.simulation;

import java.util.logging.Logger;
import static bike.simulation.Grid.*;

public class Bike implements GridObject {
    private static final Logger LOGGER = Logger.getLogger(Bike.class.getName());

    private Direction directionFacing;
    private Point position;

    public Bike() {
    }

    public Bike(Point position, Direction directionFacing) {
        this.position = position;
        this.directionFacing = directionFacing;
    }

    public Direction getDirectionFacing() {
        return directionFacing;
    }

    public Point getPosition() {
        return position;
    }

    private void setDirectionFacing(Direction directionFacing) {
        this.directionFacing = directionFacing;
    }

    private void setPosition(Point position) {
        this.position = position;
    }

    private Boolean isPositionSet()
    {
        return position != null;
    }

    private String getGPS()
    {
        return "(" + position.getX() + "," +
                " " + position.getY() + ")," +
                " " + directionFacing;
    }

    private boolean hasBeenPlaced() {
        if (!isPositionSet()) {
            LOGGER.severe("The Bike must be placed before Movement");
            return false;
        }

        return true;
    }

    public void reportGPS()
    {
        if (isPositionSet()) {
            LOGGER.info(getGPS());
        } else {
            LOGGER.severe("The Bike must be placed before Reporting GPS");
        }
    }


    public void moveForwardOneSpace()
    {
        if (!hasBeenPlaced())
            return;

        Point newPoint = new Point(getPosition());

        switch (getDirectionFacing()) {
            case EAST :
                newPoint.moveUnit(1,0);
                moveBikeIfValid(newPoint);
                break;
            case WEST :
                newPoint.moveUnit(-1,0);
                moveBikeIfValid(newPoint);
                break;
            case SOUTH :
                newPoint.moveUnit(0,-1);
                moveBikeIfValid(newPoint);
                break;
            case NORTH :
                newPoint.moveUnit(0,1);
                moveBikeIfValid(newPoint);
                break;
            default:
                LOGGER.severe("The current direction the bike is facing is invalid");
                break;
        }
    }

    private void moveBikeIfValid(Point newPoint){
        if (newPoint.isValidPoint()) {
            setPosition(newPoint);
        } else {
            LOGGER.severe("Cannot move forward as bike is at the edge of the grid");
        }
    }

    public void turnLeft()
    {
        if (!hasBeenPlaced())
            return;

        Direction currentDirection = getDirectionFacing();
        setDirectionFacing(Direction.turnLeft(currentDirection));
    }

    public void turnRight()
    {
        if (!hasBeenPlaced())
            return;

        Direction currentDirection = getDirectionFacing();
        setDirectionFacing(Direction.turnRight(currentDirection));
    }


    public void placeInGrid(Point newPosition, Direction newDirection)
    {
        if (isOutsideOfBoundary(newPosition)) {
            LOGGER.warning("Position is outside the boundary of the grid");
            return;
        }

        setPosition(newPosition);
        setDirectionFacing(newDirection);
    }

}
