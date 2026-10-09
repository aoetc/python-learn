/*
 * 第5题：华氏温 F → 摄氏温 C
 * 公式：C = (5/9) * (F - 32)
 *
 * 注意：Java 里 5/9 是两个 int 相除，结果是 0！
 * 必须写成 5.0/9 或 5/9.0
 */
import java.util.Scanner;

public class LX2_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入华氏度：");
        double f=sc.nextDouble();

        double c = (5.0 / 9) * (f - 32);

        System.out.println("华氏温度 F = " + f);
        System.out.println("摄氏温度 C = " + c);
        sc.close();
    }
}
