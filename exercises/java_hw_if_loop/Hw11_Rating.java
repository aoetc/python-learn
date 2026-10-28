/** 11. 销售金额五档：优≥6000，良≥4000，中≥2000，合格≥1000，否则不合格。 */
import java.util.Scanner;

public class Hw11_Rating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("总销售金额: ");
        double sales = sc.nextDouble();
        String level;
        if (sales >= 6000) {
            level = "优";
        } else if (sales >= 4000) {
            level = "良";
        } else if (sales >= 2000) {
            level = "中";
        } else if (sales >= 1000) {
            level = "合格";
        } else {
            level = "不合格";
        }
        System.out.println("业绩评价: " + level);
        sc.close();
    }
}
