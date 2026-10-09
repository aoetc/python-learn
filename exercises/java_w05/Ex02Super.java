/*
 * ========== 题干 Ex02 ==========
 * Person2(String name) { this.name = name; }
 * Student2(String name, int score) {
 *     super(name);   // 第一行：调用父类构造
 *     this.score = score;
 * }
 * main：Student2 s = new Student2("li", 90); s.show();
 * Run：只点 Ex02Super
 * ==============================
 */

public class Ex02Super {
    public static void main(String[] args) {
        System.out.println("【Ex02】super 调父类构造");

        // --- TODO: new Student2("li", 90); 再 show() ---

    }
}

class Person2 {
    String name;

    // --- TODO: 写构造 Person2(String name) ---

}

class Student2 extends Person2 {
    int score;

    // --- TODO: 写构造，第一行 super(name); 再 this.score = score; ---

    void show() {
        System.out.println("姓名: " + name + "  成绩: " + score);
    }
}
