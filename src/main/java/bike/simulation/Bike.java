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

    private void verifyBikeHasBeenPlaced() {
        if (position == null) {
            throw new BikeNotPlacedException();
        }
    }

    public void reportGPS() {
        verifyBikeHasBeenPlaced();

        LOGGER.info(this.toString());
    }

    public void moveForward() {
        verifyBikeHasBeenPlaced();

        Point newPoint = new Point(getPosition());

        switch (getDirectionFacing()) {
            case NORTH :
                newPoint.moveNorth();
                moveBikeIfValid(newPoint);
                break;
            case EAST :
                newPoint.moveEast();
                moveBikeIfValid(newPoint);
                break;
            case SOUTH :
                newPoint.moveSouth();
                moveBikeIfValid(newPoint);
                break;
            case WEST :
                newPoint.moveWest();
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

    public void turnLeft() {
        verifyBikeHasBeenPlaced();

        Direction currentDirection = getDirectionFacing();
        setDirectionFacing(Direction.turnLeft(currentDirection));
    }

    public void turnRight() {
        verifyBikeHasBeenPlaced();

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

    @Override
    public String toString() {
        return "(" + position.getX() +
                "," + position.getY()
                + "), " + directionFacing;
    }
}
