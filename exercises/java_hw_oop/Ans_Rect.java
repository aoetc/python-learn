class Rect {
    double length, width;

    Rect(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double perimeter() { return 2 * (length + width); }
    double area() { return length * width; }
}

public class Ans_Rect {
    public static void main(String[] args) {
        Rect r = new Rect(5, 3);
        System.out.println("周长: " + r.perimeter());
        System.out.println("面积: " + r.area());
    }
}
