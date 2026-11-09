/** 抽象类 Shape：圆 / 三角形 / 长方形 */
abstract class ShapeAbs {
    abstract double area();
    abstract double perimeter();
}

class CircleAbs extends ShapeAbs {
    double r;

    CircleAbs(double r) { this.r = r; }

    double area() { return Math.PI * r * r; }
    double perimeter() { return 2 * Math.PI * r; }
}

class TriangleAbs extends ShapeAbs {
    double a, b, c;

    TriangleAbs(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
    }

    double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    double perimeter() { return a + b + c; }
}

class SquareAbs extends ShapeAbs {
    double w, h;

    SquareAbs(double w, double h) { this.w = w; this.h = h; }

    double area() { return w * h; }
    double perimeter() { return 2 * (w + h); }
}

public class Ans_07_AbstractShape {
    public static void main(String[] args) {
        ShapeAbs[] arr = {
            new CircleAbs(3),
            new TriangleAbs(3, 4, 5),
            new SquareAbs(4, 5)
        };
        for (ShapeAbs s : arr) {
            System.out.println(s.getClass().getSimpleName()
                    + " 面积=" + s.area() + " 周长=" + s.perimeter());
        }
    }
}
