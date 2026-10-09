/*
 * 题5：键盘输入 amount, m, n, p，计算并打印：
 *   1) n/p + 3
 *   2) m/p + n - 10*amount    （书上 10amount 在 Java 要写成 10*amount）
 *   3) m - 3*n + 4*amount
 *   4) (m+n)/(p+amount)
 *   5) 18 % p                 （取余，p 最好是 int）
 *
 * 类型建议：
 *   - 除法想要小数：用 double 变量，或把参与除法的写成 double
 *   - % 取余：两边用 int（若 p 是 double，% 规则不同，作业一般用 int）
 */
import java.util.Scanner;

public class P05_Expressions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入amount:");
        double amount=sc.nextDouble();
        System.out.print("请输入m:");
        double m=sc.nextDouble();
        System.out.print("请输入n:");
        double n=sc.nextDouble();
        System.out.print("请输入p:");
        double p=sc.nextDouble();
        System.out.println(" n/p + 3="+  (n/p + 3));
        System.out.println("m/p + n - 10*amount="+(m/p + n - 10*amount));
        System.out.println("m - 3*n + 4*amount="+(m - 3*n + 4*amount));
        System.out.println("(m+n)/(p+amount)="+((m+n)/(p+amount)));
        System.out.println("18 % p="+(18 % p));
        sc.close();
    }
}
