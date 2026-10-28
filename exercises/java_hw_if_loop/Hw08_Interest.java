/** 8. 存款超过 5 年利率 7.5%，否则 5.4%。 */
import java.util.Scanner;

public class Hw08_Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("存款年数 numYears: ");
        int numYears = sc.nextInt();
        double rate = numYears > 5 ? 0.075 : 0.054;
        System.out.println("年利率: " + (rate * 100) + "%");
        sc.close();
    }
}
