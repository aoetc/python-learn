/** this / super：子类字段隐藏父类同名变量时，用 super.x 访父类，this.x 访自己 */
class Point {
    protected int x, y;

    Point(int a, int b) {
        setPoint(a, b);
    }

    public void setPoint(int a, int b) {
        x = a;
        y = b;
    }
}

class Line extends Point {
    protected int x, y;

    Line(int a, int b) {
        super(a, b); // 必须第一条：先构造父类那份 (a,b)
        setLine(a, b);
    }

    public void setLine(int x, int y) {
        this.x = x + x; // 子类自己的 x
        this.y = y + y;
    }

    public double length() {
        int x1 = super.x, y1 = super.y, x2 = this.x, y2 = this.y;
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public String toString() {
        return "直线端点：[" + super.x + "," + super.y + "] [" + x + "," + y
                + "] 直线长度：" + this.length();
    }
}

public class Ans_04_ThisSuper {
    public static void main(String[] args) {
        Line line = new Line(50, 50);
        System.out.println(line.toString());
    }
}
