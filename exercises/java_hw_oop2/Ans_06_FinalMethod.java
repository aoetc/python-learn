/**
 * final 方法：子类不能覆盖。原题 main 里写成了 c4_1，应为 c4_2 / 本类。
 * z1=add(2,3)=5；z2=mul(2,3)=add(1,7)+2*3=8+6=14
 */
class A1 {
    final int add(int x, int y) {
        return x + y;
    }

    int mul(int a, int b) {
        return add(1, 7) + a * b;
    }
}

public class Ans_06_FinalMethod extends A1 {
    /*
     * int add(int x, int y) { return x + y + 2; }  // 不能覆盖 final
     */
    public static void main(String[] args) {
        int a = 2, b = 3;
        Ans_06_FinalMethod p1 = new Ans_06_FinalMethod();
        int z1 = p1.add(a, b);
        int z2 = p1.mul(a, b);
        System.out.println("z1=" + z1);
        System.out.println("z2=" + z2);
    }
}
