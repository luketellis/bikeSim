package bike.simulation;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public int getX() {
        return (int) this.x;
    }

    public int getY() {
        return (int) this.y;
    }

    public Point getLocation() {
        return new Point(this.x, this.y);
    }

    public void setLocation(Point p) {
        this.setLocation(p.x, p.y);
    }

    public void setLocation(int x, int y) {
        this.move(x, y);
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUnit(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void moveWest() {
        this.x--;
    }

    public void moveNorth() {
        this.y++;
    }

    public void moveSouth() {
        this.y--;
    }

    public Boolean validatePoint()
    {
        if (x > 7 || y > 7 || x < 0 || y < 0)
            return false;

        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return super.equals(obj);
        } else {
            Point pt = (Point) obj;
            return this.x == pt.x && this.y == pt.y;
        }
    }

    public String toString() {
        return "Point" + "[x=" + this.x + ",y=" + this.y + "]";
    }
}
