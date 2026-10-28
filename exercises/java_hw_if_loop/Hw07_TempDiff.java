/** 7. 温差大于 2.3 则 (temp1-temp2)*factor，否则 error。factor 题目没给死，这里一起输入。 */
import java.util.Scanner;

public class Hw07_TempDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("temp1 temp2 factor: ");
        double temp1 = sc.nextDouble();
        double temp2 = sc.nextDouble();
        double factor = sc.nextDouble();
        if (temp1 - temp2 > 2.3) {
            System.out.println((temp1 - temp2) * factor);
        } else {
            System.out.println("error");
        }
        sc.close();
    }
}
