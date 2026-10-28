class Point {
    public double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void show() {
        System.out.println("(" + x + "," + y + ")");
    }

    Point getMiddle(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
}

class TriangleP {
    Point pointA, pointB, pointC;

    TriangleP(Point a, Point b, Point c) {
        pointA = a;
        pointB = b;
        pointC = c;
    }

    double dist(Point p, Point q) {
        double dx = p.x - q.x;
        double dy = p.y - q.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    double perimeter() {
        return dist(pointA, pointB) + dist(pointB, pointC) + dist(pointC, pointA);
    }

    double area() {
        // 海伦公式
        double ab = dist(pointA, pointB);
        double bc = dist(pointB, pointC);
        double ca = dist(pointC, pointA);
        double s = (ab + bc + ca) / 2;
        return Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
    }
}

public class Ans_PointTriangle {
    public static void main(String[] args) {
        TriangleP t = new TriangleP(
                new Point(0, 0), new Point(4, 0), new Point(0, 3));
        System.out.println("周长: " + t.perimeter());
        System.out.println("面积: " + t.area());
    }
}
