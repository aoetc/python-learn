/*
 * ========== 题干 Ex02 ==========
 * Student 构造方法重载三份：
 *   Student()                     → name="未命名", score=0
 *   Student(String name)          → 只用 this 设 name，score=0
 *   Student(String name, int score) → this 设两个字段
 *
 * main 里分别 new 三种，都调用 show()
 * ==============================
 *
 * Run：只点 Ex02CtorOverload 的绿三角，不要点 Student
 */

public class Ex02CtorOverload {
    public static void main(String[] args) {
        System.out.println("【Ex02】构造方法重载");
        Student a=new Student();
        Student b=new Student("李");
        Student c=new Student("李",90);
        a.show();
        b.show();
        c.show();

    }
}

class Student {
    String name;
    int score;
    Student(){
        name="not named";
        score=0;
    }
    Student(String name){
        this.name=name;
        score=0;
    }
    Student(String name,int score){
        this.name=name;
        this.score=score;
    }

    void show() {
        System.out.println("姓名: " + name + "  成绩: " + score);
    }
}
