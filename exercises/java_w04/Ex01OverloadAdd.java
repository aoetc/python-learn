/*
 * ========== 题干 Ex01 ==========
 * 在 Calculator 类中写三个同名方法 add（重载）：
 *   int add(int a, int b)           → 返回 a+b
 *   int add(int a, int b, int c)    → 返回 a+b+c
 *   double add(double a, double b)  → 返回 a+b
 *
 * 在 main 里分别调用三次并打印结果，例如：
 *   两数之和: 3
 *   三数之和: 6
 *   小数之和: 3.5
 *
 * 注意：只有返回类型不同、参数完全一样 → 不算合法重载
 * ==============================
 */

public class Ex01OverloadAdd {
    public static void main(String[] args) {
        System.out.println("【Ex01】方法重载 add");

        Calculator c = new Calculator();
        c.add(1,2);
        c.add(1,2,3);
        c.add(1.5,2);
        System.out.println(c.add(1,2));
        System.out.println(c.add(1,2,3));
        System.out.println(c.add(1.5,2));

    }
}

class Calculator {
    int add(int a,int b){
        return a+b;
    }
    int add(int a,int b,int c){
        return a+b+c;
    }
    double add(double a,double b){
        return a+b;
    }

}
