package bike.simulation;

import java.util.logging.Logger;

public enum Direction {
    EAST,
    NORTH,
    SOUTH,
    WEST;

    private static final Logger LOGGER = Logger.getLogger(Bike.class.getName());

    public static Direction turnLeft(Direction direction) {
        switch (direction) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                LOGGER.severe("Invalid Direction");
                return null;
        }
    }

    public static Direction turnRight(Direction direction) {
        switch (direction) {
            case NORTH:
                return Direction.EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                LOGGER.severe("Invalid Direction");
                return null;
        }
    }

    public static Direction asDirection(String str) {
        for (Direction i : Direction.values()) {
            if (i.name().equalsIgnoreCase(str))
                return i;
        }
        return null;
    }
}
