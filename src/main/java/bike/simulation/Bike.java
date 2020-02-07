package bike.simulation;

import java.util.logging.Logger;

public class Bike implements GridObject {
    private static final Logger LOGGER = Logger.getLogger(Bike.class.getName());

    private Direction directionFacing;
    private Point position;

    public Direction getDirectionFacing() {
        return directionFacing;
    }

    public Point getPosition() {
        return position;
    }

    public void setDirectionFacing(Direction directionFacing) {
        this.directionFacing = directionFacing;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Boolean isPositionSet()
    {
        return position != null;
    }

    public String getGPS()
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
            return;
        }

    }


    public void moveForward()
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
                LOGGER.severe("The Current Direction the Bike is Facing is Invalid");
                break;
        }
    }

    private void moveBikeIfValid(Point newPoint){
        if (!newPoint.validatePoint()) {
            LOGGER.severe("Cannot Move Forward as Bike will leave the Grid");
        } else {
            setPosition(newPoint);
        }
    }

    public void turnLeft()
    {
        if (hasBeenPlaced())
            return;

        switch (getDirectionFacing()) {
            case NORTH:
                setDirectionFacing(Direction.WEST);
                break;
            case WEST:
                setDirectionFacing(Direction.SOUTH);
                break;
            case SOUTH:
                setDirectionFacing(Direction.EAST);
                break;
            case EAST:
                setDirectionFacing(Direction.NORTH);
                break;
            default:
                LOGGER.severe("Invalid Direction");
                break;
        }
    }

    public void turnRight()
    {
        if (!hasBeenPlaced())
            return;

        switch (getDirectionFacing()) {
            case NORTH:
                setDirectionFacing(Direction.EAST);
                break;
            case WEST:
                setDirectionFacing(Direction.NORTH);
                break;
            case SOUTH:
                setDirectionFacing(Direction.WEST);
                break;
            case EAST:
                setDirectionFacing(Direction.SOUTH);
                break;
            default:
                LOGGER.severe("Invalid Direction");
                break;
        }

    }


    public void place(Point newPosition, Direction newDirection)
    {
        setPosition(newPosition);
        setDirectionFacing(newDirection);
    }


    public void determinePositionToSet(Direction direction)
    {
        switch (direction) {
            case NORTH:
            case EAST :
            case SOUTH:
            case WEST :
                setDirectionFacing(direction);
                break;
            default:
                LOGGER.severe("Invalid Direction.");
                break;
        }
    }


}
