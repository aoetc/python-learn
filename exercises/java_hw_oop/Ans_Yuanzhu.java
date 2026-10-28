/** 圆柱：原题公式缺运算符，已修正 */
class Yuanzhu {
    double r, high;

    public Yuanzhu(double r, double high) {
        this.r = r;
        this.high = high;
    }

    public double getR() { return r; }
    public void setR(double r) { this.r = r; }
    public double getHigh() { return high; }
    public void setHigh(double high) { this.high = high; }

    public double diArea() {
        return Math.PI * r * r; // 底面积
    }

    public double biaoArea() {
        return 2 * diArea() + 2 * Math.PI * r * high; // 表面积
    }

    public double tiji() {
        return diArea() * high;
    }
}

public class Ans_Yuanzhu {
    public static void main(String[] args) {
        Yuanzhu y = new Yuanzhu(2, 5);
        System.out.println("底面积: " + y.diArea());
        System.out.println("表面积: " + y.biaoArea());
        System.out.println("体积: " + y.tiji());
    }
}
