/** static 变量/方法 与 实例变量/方法 */
class StaticDemo {
    static int x = 10; // 类变量，大家共用
    int y = 20;        // 实例变量，每个对象一份

    static int getX() { return x; }
    int getY() { return y; }
}

public class Ans_StaticDemo {
    public static void main(String[] args) {
        System.out.println("类变量 x=" + StaticDemo.getX());
        // System.out.println(StaticDemo.getY()); // 错：实例方法不能用类名直接调

        StaticDemo s = new StaticDemo();
        System.out.println("实例变量 y=" + s.getY());
        System.out.println("通过对象也可访问 static: " + s.getX());
    }
}
