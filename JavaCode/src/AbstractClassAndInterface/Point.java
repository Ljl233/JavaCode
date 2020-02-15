package AbstractClassAndInterface;

import java.util.Arrays;

public class Point implements MyComparable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance() {
        testB();//可以调用testB(),不能调用testA()
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public  int compare(Object other) {
        if (!(other instanceof Point)) {
            throw new IllegalArgumentException();
        }
        Point otherPoint = (Point) other;
        double delta = distance() - otherPoint.distance();
        if (delta > 0)
            return 1;
        else if (delta < 0)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
