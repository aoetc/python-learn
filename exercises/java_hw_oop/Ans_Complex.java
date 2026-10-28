/** 复数类 */
class Complex {
    int x, y;

    Complex() { x = 0; y = 0; }
    Complex(int i, int j) { x = i; y = j; }

    void showComp() {
        if (y >= 0) {
            System.out.println(x + "+" + y + "i");
        } else {
            System.out.println(x + "" + y + "i"); // y 自带负号
        }
    }

    Complex addComp(Complex c1, Complex c2) {
        return new Complex(c1.x + c2.x, c1.y + c2.y);
    }

    Complex subComp(Complex c1, Complex c2) {
        return new Complex(c1.x - c2.x, c1.y - c2.y);
    }

    boolean equalComp(Complex c1, Complex c2) {
        return c1.x == c2.x && c1.y == c2.y;
    }
}

public class Ans_Complex {
    public static void main(String[] args) {
        Complex a = new Complex(5, 8);
        Complex b = new Complex(3, -2);
        a.showComp();
        b.showComp();
        Complex c = new Complex();
        c.addComp(a, b).showComp();
        c.subComp(a, b).showComp();
        System.out.println("相等? " + c.equalComp(a, b));
    }
}
