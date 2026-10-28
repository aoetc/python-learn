/** 9. ≤40 小时按 8 美元；超过部分每小时 12 美元。 */
import java.util.Scanner;

public class Hw09_Salary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("工作小时数: ");
        double hours = sc.nextDouble();
        double pay = hours <= 40 ? hours * 8 : 320 + (hours - 40) * 12;
        System.out.println("周薪: " + pay + " 美元");
        sc.close();
    }
}
