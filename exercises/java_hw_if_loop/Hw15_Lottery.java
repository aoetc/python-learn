/** 15. 1 苹果 / 2 鸭梨 / 3 橘子；其它没奖；# 结束。 */
import java.util.Scanner;

public class Hw15_Lottery {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("输入 1/2/3 抽奖，输入 # 结束");
        while (true) {
            String c1 = cin.nextLine();
            if (c1.isEmpty()) {
                continue;
            }
            char c = c1.charAt(0);
            if (c == '#') {
                System.out.println("结束");
                break;
            }
            switch (c) {
                case '1' -> System.out.println("苹果");
                case '2' -> System.out.println("鸭梨");
                case '3' -> System.out.println("橘子");
                default -> System.out.println("没有奖品给你!");
            }
        }
        cin.close();
    }
}
