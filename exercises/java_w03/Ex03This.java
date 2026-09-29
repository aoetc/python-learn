/*
 * ========== 题干 Ex03 ==========
 * 用 this 区分字段和参数；main 里 new 并 show()
 * ==============================
 *
 * 【怎么 Run 才不会报「未包含 main」】
 * 1. 打开本文件 Ex03This.java
 * 2. 点 public class Ex03This 左侧的绿色三角
 *    或把光标放在 main 那一行再点 Run
 * 3. 不要点 Student3 旁边的 Run（Student3 没有 main）
 */

public class Ex03This {
    public static void main(String[] args) {
        System.out.println("【Ex03】this 区分字段和参数");

        Student3 a = new Student3("李", 90);
        a.show();
    }
}

class Student3 {
    String name;
    int score;

    Student3(String name, int score) {
        this.name = name;
        this.score = score;
    }

    void show() {
        System.out.println("姓名: " + name + "  成绩: " + score);
    }
}
