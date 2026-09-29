/*
 * ========== 题干 Ex02 ==========
 * 用构造方法创建学生，再 show()
 * ==============================
 */

public class Ex02Constructor {
    public static void main(String[] args) {
        System.out.println("【Ex02】构造方法创建学生");

        // new 和 show 必须写在 main 里面
        Student2 a = new Student2("李", 90);
        a.show();
    }
}

class Student2 {
    String name;
    int score;

    // 参数之间用逗号 ,  不是分号 ;
    Student2(String n, int s) {
        name = n;
        score = s;
    }

    void show() {
        System.out.println("姓名: " + name + "  成绩: " + score);
    }
}
