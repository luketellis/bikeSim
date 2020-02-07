package bike.simulation;

public class Grid {
    static final int MAXIMUM_X = 6;
    static final int MAXIMUM_Y = 6;

    public boolean isOutsideOfXBoundary(int x)
    {
        if (x < 0 ||x > MAXIMUM_X)
        {
            return true;
        }
        return false;
    }

    public boolean isOutsideOfYBoundary(int y)
    {
        if (y < 0 ||y > MAXIMUM_Y)
        {
            return true;
        }
        return false;
    }

    public boolean isOutsideOfBoundary(Point point)
    {
        return isOutsideOfXBoundary(point.getX()) || isOutsideOfYBoundary(point.getY());
    }

    public void drawGrid()
    {
        int j;
        for (int i = 6; i > -1; i--)
        {
            for (j = 6; j > -1; j--)
            {
                System.out.print("_");
            }
            j = 6;
            System.out.println();
        }
    }

}
