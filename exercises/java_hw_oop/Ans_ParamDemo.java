/** 简单类型按值传递；对象按引用传递 */
class People {
    int money;
    void setMoney(int n) { money = n; }
}

class ParamHelper {
    void f(double y, People p) {
        y = y + 1;
        p.setMoney(100);
        System.out.println("参数y的值是:" + y);
        System.out.println("参数对象p的money是:" + p.money);
    }
}

public class Ans_ParamDemo {
    public static void main(String[] args) {
        double y = 0.8;
        People zhang = new People();
        zhang.setMoney(8888);
        ParamHelper a = new ParamHelper();
        System.out.println("调用前 zhang.money=" + zhang.money + " y=" + y);
        a.f(y, zhang);
        System.out.println("调用后 y仍然是:" + y);          // 仍是 0.8
        System.out.println("调用后 zhang.money是:" + zhang.money); // 变成 100
    }
}
