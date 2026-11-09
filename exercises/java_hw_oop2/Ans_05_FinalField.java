/**
 * final 字段：声明后可在构造里赋一次；之后不能再改。
 * 原题 m1.nn=90 非法；Applet 改成普通 main 方便在 IDEA 跑。
 */
class Ca {
    static int n = 20;
    final int nn;
    final int k = 40;

    Ca() {
        nn = ++n; // 每个对象构造时赋一次
    }
}

public class Ans_05_FinalField {
    public static void main(String[] args) {
        Ca m1 = new Ca(); // nn=21
        Ca m2 = new Ca(); // nn=22
        // m1.nn = 90; // 编译错误：final 不能再赋值
        System.out.println("m2.nn=" + m2.nn);
        System.out.println("m2.k=" + m2.k);
        System.out.println("m1.nn=" + m1.nn);
        System.out.println("m1.k=" + m1.k);
    }
}
