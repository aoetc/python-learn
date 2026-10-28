/*
 * 10. 分段函数，x 从键盘读入
 *   x <= 0       → Math.abs(3 * x + 5)
 *   0 < x < 100  → 2 * Math.exp(x) - 1
 *   x >= 100     → x * x - x + 3
 */
import java.util.Scanner;

public class Hw10_Piecewise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.print("请输入 x: ");
        double x = sc.nextDouble();

        double y; 
        if (x <= 0) {
            y = Math.abs(3 * x + 5);
        } else if (x < 100) {  
            y = 2 * Math.exp(x) - 1;
        } else {
            y = x * x - x + 3;
        }

        System.out.println("y = " + y);
        sc.close();
    }
}
