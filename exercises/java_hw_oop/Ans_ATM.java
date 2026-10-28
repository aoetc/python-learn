/** ATM 简易模拟：卡号密码 123456，菜单循环 */
import java.util.Scanner;

class ATM {
    long card = 123456;
    long password = 123456;
    double balance = 0;

    boolean login(long c, long p) {
        return c == card && p == password;
    }

    void query() {
        System.out.println("余额: " + balance + " 元");
    }

    boolean withdraw(double money) {
        if (money <= 0 || money % 100 != 0 || money > 5000) {
            System.out.println("取款金额须为100的倍数且不超过5000");
            return false;
        }
        if (money > balance) {
            System.out.println("余额不足");
            return false;
        }
        balance -= money;
        System.out.println("取款成功");
        return true;
    }

    boolean deposit(double money) {
        if (money <= 0) {
            System.out.println("不能负存款或0");
            return false;
        }
        balance += money;
        System.out.println("存款成功");
        return true;
    }

    boolean changePwd(long oldP, long newP1, long newP2) {
        if (oldP != password) {
            System.out.println("旧密码错误");
            return false;
        }
        if (String.valueOf(newP1).length() < 6 || newP1 != newP2) {
            System.out.println("新密码不合格或不一致");
            return false;
        }
        password = newP1;
        System.out.println("改密成功");
        return true;
    }
}

public class Ans_ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();
        System.out.print("卡号: ");
        long c = sc.nextLong();
        System.out.print("密码: ");
        long p = sc.nextLong();
        if (!atm.login(c, p)) {
            System.out.println("登录失败");
            sc.close();
            return;
        }
        while (true) {
            System.out.println("1查询 2取款 3存款 4改密 0退出");
            int op = sc.nextInt();
            if (op == 0) break;
            switch (op) {
                case 1 -> atm.query();
                case 2 -> {
                    System.out.print("取款金额: ");
                    atm.withdraw(sc.nextDouble());
                }
                case 3 -> {
                    System.out.print("存款金额: ");
                    atm.deposit(sc.nextDouble());
                }
                case 4 -> {
                    System.out.print("旧密码 新密码 确认新密码: ");
                    atm.changePwd(sc.nextLong(), sc.nextLong(), sc.nextLong());
                }
                default -> System.out.println("无效选项");
            }
        }
        sc.close();
    }
}
