/** 覆盖 Object.toString()，返回半径和面积信息 */
class Circle {
    private int radius;

    Circle(int r) {
        radius = r;
    }

    public void setRadius(int r) {
        radius = r;
    }

    public int getRadius() {
        return radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return "圆半径=" + radius + "，面积=" + area();
    }
}

public class Hw03_CircleToString {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println(c); // 自动调 toString()
        c.setRadius(10);
        System.out.println(c.toString());
    }
}
