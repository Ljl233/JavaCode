package AbstractClassAndInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PointTest {

    public static void main(String[] args) {
        Point a = new Point(1, 2);
        Point b = new Point(2, 3);

        Point[] points = new Point[2];

        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double delta = o1.distance() - o2.distance();
                if (delta > 0)
                    return 1;
                else if (delta < 0)
                    return -1;
                else
                    return 0;
            }
        };
        Arrays.sort(points, comparator);

    }

    static <T extends MyComparable> void sort(T[] ts) {

        int length = ts.length;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (ts[i].compare(ts[j]) > 0) {
                    swap(ts, i, j);
                }
            }
        }

    }

    static void swap(Object[] objects, int i, int j) {

    }
}
