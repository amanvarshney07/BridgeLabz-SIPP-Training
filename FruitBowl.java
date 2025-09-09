import java.util.*;

public class FruitBowl {
    static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Point other) {
            if (this.x == other.x) return this.y - other.y;
            return this.x - other.x;
        }
    }

    static long cross(Point O, Point A, Point B) {
        return (long)(A.x - O.x) * (B.y - O.y) - (long)(A.y - O.y) * (B.x - O.x);
    }

    static double dist(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        int N = sc.nextInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(points);
        List<Point> hull = new ArrayList<>();
        for (Point p : points) {
            while (hull.size() >= 2 && cross(hull.get(hull.size()-2), hull.get(hull.size()-1), p) <= 0) {
                hull.remove(hull.size()-1);
            }
            hull.add(p);
        }
        int lowerSize = hull.size();
        for (int i = N-2; i >= 0; i--) {
            Point p = points[i];
            while (hull.size() > lowerSize && cross(hull.get(hull.size()-2), hull.get(hull.size()-1), p) <= 0) {
                hull.remove(hull.size()-1);
            }
            hull.add(p);
        }
        hull.remove(hull.size()-1);

        double perimeter = 0.0;
        for (int i = 0; i < hull.size(); i++) {
            Point a = hull.get(i);
            Point b = hull.get((i+1) % hull.size());
            perimeter += dist(a, b);
        }

        System.out.println(Math.round(perimeter));
    }
    }
}
