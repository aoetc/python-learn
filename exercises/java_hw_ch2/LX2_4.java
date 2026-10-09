/*
 * 第4题：圆面积和周长（键盘输入半径）
 */
import java.util.Scanner;

public class LX2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入半径: ");
        double radius = sc.nextDouble();

        double area = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius;

        System.out.println("半径 r = " + radius);
        System.out.println("圆面积 = " + area);
        System.out.println("圆周长 = " + perimeter);

        sc.close();
    }
}
