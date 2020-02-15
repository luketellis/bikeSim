package bike.simulation;

public class Grid {
    private static final int MAXIMUM_X = 6;
    private static final int MAXIMUM_Y = 6;

    //Suppress default constructor for non-instantiability
    private Grid() {
        throw new AssertionError();
    }

    static boolean isOutsideOfXBoundary(int x)
    {
        return x < 0 || x > MAXIMUM_X;
    }

    static boolean isOutsideOfYBoundary(int y)
    {
        return y < 0 || y > MAXIMUM_Y;
    }

    static boolean isOutsideOfBoundary(Point point)
    {
        return isOutsideOfXBoundary(point.getX()) || isOutsideOfYBoundary(point.getY());
    }

    protected static void drawGrid()
    {
        for (int i = MAXIMUM_Y; i > -1; i--)
        {
            for (int j = MAXIMUM_X; j > -1; j--)
            {
                System.out.print("_");
            }
            System.out.println();
        }
    }
}
