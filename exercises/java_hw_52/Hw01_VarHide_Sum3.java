/** 简答1：成员变量的继承与隐藏 */
class Sum_3 {
    int sum, num1, num2;
    static int num3;

    Sum_3() {
        num1 = num2 = num3 = sum = 0;
    }
}

class Sub_sum3 extends Sum_3 {
    int sum, num1, num2;
    static int num3;

    void sum(int i, int j, int k) {
        num1 = i;
        num2 = j;
        num3 = k;
        sum = num1 + num2 + num3;
    }
}

public class Hw01_VarHide_Sum3 {
    public static void main(String[] args) {
        Sub_sum3 m1 = new Sub_sum3();
        m1.sum(100, 200, 300);
        System.out.println("sum=" + m1.num1 + "+" + m1.num2 + "+" + m1.num3 + "=" + m1.sum);
        // 输出：sum=100+200+300=600（用的是子类自己隐藏后的那份变量）
    }
}
