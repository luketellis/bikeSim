package bike.simulation;

public interface GridObject {
    void reportGPS();

    void moveForward();

    void turnLeft();

    void turnRight();

    void place(Point newPosition, Direction newDirection);

    void determinePositionToSet(Direction direction);
}
