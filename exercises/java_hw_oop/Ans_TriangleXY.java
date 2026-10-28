/** 两边夹角求面积：h = y * sin(a)，注意 a 要转成弧度。 */
class TriangleXY {
    int x, y;
    double a; // 角度，度

    TriangleXY(int xx, int yy, double aa) {
        x = xx;
        y = yy;
        a = aa;
    }

    double area() {
        double rad = Math.toRadians(a);
        double h = y * Math.sin(rad);
        return x * h / 2.0;
    }

    void setAngle(double aa) {
        a = aa;
    }
}

public class Ans_TriangleXY {
    public static void main(String[] args) {
        TriangleXY t1 = new TriangleXY(3, 4, 90);
        TriangleXY t2 = new TriangleXY(5, 5, 60);
        System.out.println("t1面积: " + t1.area());
        System.out.println("t2面积: " + t2.area());
        t1.setAngle(60);
        System.out.println("t1改角后面积: " + t1.area());
    }
}
