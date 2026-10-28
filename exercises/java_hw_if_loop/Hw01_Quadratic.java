/*
 * 1. 一元二次方程 ax^2 + bx + c = 0
 * 三种判别式：>0 两个实根；=0 一个实根；<0 复数根（实部+虚部）
 */
public class Hw01_Quadratic {
    public static void main(String[] args) {
        // 三组测试：分别对应 delta>0、=0、<0
        System.out.println("===== 测试1：delta > 0 =====");
        solve(1, -3, 2);   // 根应为 2 和 1

        System.out.println("===== 测试2：delta = 0 =====");
        solve(1, -2, 1);   // 重根应为 1

        System.out.println("===== 测试3：delta < 0 =====");
        solve(1, 2, 5);    // 复数根
    }

    static void solve(double a, double b, double c) {
        System.out.println("方程: " + a + "x^2 + " + b + "x + " + c + " = 0");
        double delta = b * b - 4 * a * c;
        System.out.println("判别式 delta = " + delta);

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("两个不相等实根: x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("两个相等实根: x = " + x);
        } else {
            double real = -b / (2 * a);
            double imag = Math.sqrt(-delta) / (2 * a);
            System.out.println("无实根，复数根: " + real + "+" + imag + "i  和  "
                    + real + "-" + imag + "i");
        }
        System.out.println();
    }
}
