import java.util.ArrayList;

public class test_9
{
    private static ArrayList<Point> points;

    static class Point
    {
        int x;
        int y;

        public static void main(String[] args)
        {
            Point point = new Point();
            point.x = 100;
            point.y = 200;

            // будет работать
            points = new ArrayList<Point>();
            points.add(point);
        }
    }
}