/*
 * ========== 题干 Ex03 ==========
 * Person3.show()：打印 我是: name
 * Student3 继承 Person3，@Override show()：打印 我是: name, 成绩: score
 *
 * main：
 *   Person3 p = new Person3("路人");
 *   Student3 s = new Student3("李宏", 90);
 *   p.show();
 *   s.show();   // 走子类重写后的版本
 *
 * 这叫覆盖（override）：子类改写父类「同名同参数」的方法
 * 和重载不同：重载是参数不同；覆盖是父子、签名相同
 * Run：只点 Ex03OverrideIntro
 * ==============================
 */

public class Ex03OverrideIntro {
    public static void main(String[] args) {
        System.out.println("【Ex03】覆盖 override 入门");

        // --- TODO ---

    }
}

class Person3 {
    String name;

    Person3(String name) {
        this.name = name;
    }

    void show() {
        System.out.println("我是: " + name);
    }
}

class Student3 extends Person3 {
    int score;

    Student3(String name, int score) {
        super(name);
        this.score = score;
    }

    // --- TODO: @Override void show() { ... } ---
}
