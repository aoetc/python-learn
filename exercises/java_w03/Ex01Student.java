/*
 * ========== 题干 Ex01 ==========
 * Student：字段 name、score；方法 show()
 * main：new 两个学生并 show()
 * ==============================
 */

public class Ex01Student {
    public static void main(String[] args) {
        System.out.println("【Ex01】类与对象：Student + show()");

        Student a = new Student();
        a.name = "李";
        a.score = 90;
        a.show();

        Student b = new Student();
        b.name = "王";
        b.score = 85;
        b.show();
    }
}

// 类写在 main 外面（和 W02 的方法一样：定义不放进 main 里面）
class Student {
    String name;
    int score;

    void show() {
        System.out.println("姓名: " + name + "  成绩: " + score);
    }
}
