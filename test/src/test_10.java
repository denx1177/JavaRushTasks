import java.util.ArrayList;

public class test_10 {
    private static ArrayList<Point> points;
}

class Point {
    int x;
    int y;

    public static void main(String[] args) {
        Point point = new Point();
        point.x = 100;
        point.y = 200;

        // тут будет ошибка
//        points = new ArrayList<Point>();
//        points.add(point);
    }
}
