/** 7. 蜗牛爬井：每秒爬 m，休息 1 秒下滑 n，求总秒数。到井口即成功。 */
import java.util.Scanner;

public class Hw07_Snail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入 h m n (厘米): ");
        double h = sc.nextDouble();
        double m = sc.nextDouble();
        double n = sc.nextDouble();

        double pos = 0;
        int seconds = 0;

        while (true) {
            // 爬 1 秒
            pos += m;
            seconds++;
            if (pos >= h) {
                break; // 到达井口，不必再休息下滑
            }
            // 休息 1 秒并下滑
            pos -= n;
            seconds++;
        }

        System.out.println("需要 " + seconds + " 秒");
        sc.close();
    }
}
