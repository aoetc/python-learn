/*
 * ========== 题干 Ex01 ==========
 * Person + Student extends Person；main 里赋值、sayHi、打印成绩
 * Run：只点 Ex01Extends
 * ==============================
 */

public class Ex01Extends {
    public static void main(String[] args) {
        System.out.println("【Ex01】继承 extends");

        Student s = new Student();
        s.name = "li";
        s.score = 90;
        s.sayHi();
        System.out.println("成绩: " + s.score);
    }
}

// 类写在 main 外面（和 W03 一样）
class Person {
    String name;

    void sayHi() {
        System.out.println("你好, 我是 " + name);
    }
}

class Student extends Person {
    int score;
}
