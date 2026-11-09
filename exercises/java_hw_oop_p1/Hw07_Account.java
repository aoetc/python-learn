/*
 * Account 银行账户
 * 属性：账号、存款余额
 * 方法：存款 deposit、取款 withdraw（余额不足要提示）、查询余额
 * main 里创建对象，测存/取/查
 */
public class Hw07_Account {
    public static void main(String[] args) {
        Account a = new Account("622202001", 1000);
        a.query();
        a.deposit(500);
        a.query();
        a.withdraw(200);
        a.query();
        a.withdraw(2000); // 余额不足
        a.query();
    }
}

class Account {
    String accountNo;
    double balance;

    Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("存款金额无效");
            return;
        }
        balance += amount;
        System.out.println("存入 " + amount + " 元成功");
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("取款金额无效");
            return;
        }
        if (amount > balance) {
            System.out.println("余额不足，取款失败");
            return;
        }
        balance -= amount;
        System.out.println("取出 " + amount + " 元成功");
    }

    void query() {
        System.out.println("账号：" + accountNo + "，余额：" + balance);
    }
}
