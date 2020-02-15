package bike.simulation;

public interface GridObject {
    void reportGPS();

    void moveForward();

    void turnLeft();

    void turnRight();

    void placeInGrid(Point newPosition, Direction newDirection);
}
