/**
 * 实验5.1 第2题：成员变量隐藏。
 *
 * 原题问题：LX5_2_P m1 = new LX5_2_P(); 再 m1.sum(...) —— 父类没有 sum 方法，编不过。
 * 交作业可写：改成 LX5_2 m1 = new LX5_2(); 再调用。
 * 下面是改好可跑的版本，并对比父类引用看到的字段。
 */
class LX5_2_P {
    int sum, num1, num2;
    static int num3;

    LX5_2_P() {
        num1 = 0;
        num2 = 0;
        num3 = 0;
        sum = 0;
    }
}

class LX5_2 extends LX5_2_P {
    int sum, num1, num2; // 隐藏父类实例变量
    static int num3;     // 隐藏父类类变量

    void sum(int i, int j, int k) {
        num1 = i;
        num2 = j;
        num3 = k;
        sum = num1 + num2 + num3;
    }
}

public class Hw02_VarHide {
    public static void main(String[] args) {
        LX5_2 m1 = new LX5_2();
        m1.sum(100, 200, 300);
        System.out.println("子类看到: sum=" + m1.num1 + "+" + m1.num2 + "+" + m1.num3 + "=" + m1.sum);

        LX5_2_P p = m1; // 父类引用指向子类对象
        System.out.println("父类引用看到的字段仍是父类那份: num1=" + p.num1 + " sum=" + p.sum);
        // 字段看「引用声明的类型」；方法才动态绑定
    }
}
