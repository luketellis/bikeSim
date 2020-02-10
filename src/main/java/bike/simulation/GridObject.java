package bike.simulation;

public interface GridObject {
    void reportGPS();

    void moveForwardOneSpace();

    void turnLeft();

    void turnRight();

    void placeInGrid(Point newPosition, Direction newDirection);
}
