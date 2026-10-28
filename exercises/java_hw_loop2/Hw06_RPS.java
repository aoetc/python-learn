/** 6. 石头剪刀布：连续赢 3 / 输 3 结束；否则可选择是否继续。 */
import java.util.Random;
import java.util.Scanner;

public class Hw06_RPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[] names = {"石头", "剪刀", "布"}; // 0 石头 1 剪刀 2 布
        int winStreak = 0;
        int loseStreak = 0;

        while (true) {
            System.out.print("请选择(0石头 1剪刀 2布): ");
            int user = sc.nextInt();
            if (user < 0 || user > 2) {
                System.out.println("输入无效");
                continue;
            }
            int sys = rand.nextInt(3);
            System.out.println("你出: " + names[user] + "，系统出: " + names[sys]);

            // 判定：同则平；否则 (user - sys + 3) % 3 == 2 用户赢（石头胜剪刀等）
            if (user == sys) {
                System.out.println("平局");
                winStreak = 0;
                loseStreak = 0;
            } else if ((user - sys + 3) % 3 == 2) {
                System.out.println("你赢了");
                winStreak++;
                loseStreak = 0;
            } else {
                System.out.println("你输了");
                loseStreak++;
                winStreak = 0;
            }

            if (winStreak == 3) {
                System.out.println("运气不错");
                break;
            }
            if (loseStreak == 3) {
                System.out.println("太倒霉了");
                break;
            }

            System.out.print("是否继续？(1继续 0退出): ");
            if (sc.nextInt() == 0) {
                System.out.println("游戏结束");
                break;
            }
        }
        sc.close();
    }
}
