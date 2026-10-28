/** 方法重载 mul */
class Multiplication {
    int mul(int a, int b) { return a * b; }
    double mul(double a, double b) { return a * b; }
    double mul(double a, double b, double c) { return a * b * c; }
}

public class Ans_Multiplication {
    public static void main(String[] args) {
        Multiplication m = new Multiplication();
        System.out.println(m.mul(2, 3));
        System.out.println(m.mul(2.5, 4.0));
        System.out.println(m.mul(1.5, 2.0, 3.0));
    }
}
