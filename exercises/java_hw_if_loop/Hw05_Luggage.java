/** 5. 行李托运费 0.60 元/千克。 */
import java.util.Scanner;

public class Hw05_Luggage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入重量(千克): ");
        double weight = sc.nextDouble();
        double fee = weight * 0.60;
        System.out.println("托运费: " + fee + " 元");
        sc.close();
    }
}
