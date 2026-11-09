/** 接口 Shape + 坐标类；圆/三角/矩形继承坐标并实现接口 */
interface ShapeIf {
    double area();
    double perimeter();
}

class Coordinates {
    double x, y;

    Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class CircleIf extends Coordinates implements ShapeIf {
    double r;

    CircleIf(double x, double y, double r) {
        super(x, y);
        this.r = r;
    }

    public double area() { return Math.PI * r * r; }
    public double perimeter() { return 2 * Math.PI * r; }
}

class TriangleIf extends Coordinates implements ShapeIf {
    double a, b, c;

    TriangleIf(double x, double y, double a, double b, double c) {
        super(x, y);
        this.a = a; this.b = b; this.c = c;
    }

    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double perimeter() { return a + b + c; }
}

class SquareIf extends Coordinates implements ShapeIf {
    double w, h;

    SquareIf(double x, double y, double w, double h) {
        super(x, y);
        this.w = w; this.h = h;
    }

    public double area() { return w * h; }
    public double perimeter() { return 2 * (w + h); }
}

public class Hw08_InterfaceShape {
    public static void main(String[] args) {
        ShapeIf c = new CircleIf(0, 0, 2);
        ShapeIf t = new TriangleIf(0, 0, 3, 4, 5);
        ShapeIf s = new SquareIf(1, 1, 3, 4);
        System.out.println("圆 面积=" + c.area() + " 周长=" + c.perimeter());
        System.out.println("三角 面积=" + t.area() + " 周长=" + t.perimeter());
        System.out.println("矩形 面积=" + s.area() + " 周长=" + s.perimeter());
    }
}
