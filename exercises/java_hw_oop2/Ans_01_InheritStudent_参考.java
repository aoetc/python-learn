/** Self_01 参考：先自己写再对照 */
class LX5_1_P {
    String xm;
    String xh;

    LX5_1_P(String xm, String xh) {
        this.xm = xm;
        this.xh = xh;
    }

    void print() {
        System.out.println("姓名：" + xm + " 学号：" + xh);
    }
}

class LX5_1 extends LX5_1_P {
    String xy;
    String xi;

    LX5_1(String xm, String xh, String xy, String xi) {
        super(xm, xh);
        this.xy = xy;
        this.xi = xi;
    }

    void print() {
        System.out.println("姓名：" + xm + " 学号：" + xh + " 学院：" + xy + " 系：" + xi);
    }
}

public class Ans_01_InheritStudent_参考 {
    public static void main(String[] args) {
        LX5_1 s = new LX5_1("张三", "2026001", "信息学院", "软工");
        s.print();
    }
}
