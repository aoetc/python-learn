/*
 * 第6题：根据父母身高和孩子性别预测成年身高（cm）
 * 儿子 = (父亲 + 母亲) * 1.08 / 2
 * 女儿 = (父亲 * 0.923 + 母亲) / 2
 *
 * 下面用键盘输入；性别输入 1=儿子 2=女儿
 */
import java.util.Scanner;

public class LX2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("父亲身高(cm): ");
        double father = sc.nextDouble();
        System.out.print("母亲身高(cm): ");
        double mother = sc.nextDouble();
        System.out.print("孩子性别(1儿子 2女儿): ");
        int gender = sc.nextInt();

        double height;
        if (gender == 1) {
            height = (father + mother) * 1.08 / 2;
            System.out.println("预测儿子成年身高: " + height + " cm");
        } else if (gender == 2) {
            height = (father * 0.923 + mother) / 2;
            System.out.println("预测女儿成年身高: " + height + " cm");
        } else {
            System.out.println("性别输入无效，请输入 1 或 2");
        }

        sc.close();
    }
}
