/** 作业一：补全类 A + Test（对应代码1～15） */
class A {
    int age;                    // 代码1
    String name;                // 代码2

    public A() {
        age = 0;
        name = "";
    }

    public A(int age, String name) { // 代码3
        this.age = age;
        this.name = name;
    }

    void setAge(int x) {
        age = x;                // 代码4
    }

    void setName(String n) {    // 代码5
        name = n;
    }

    int getAge() {
        return age;             // 代码6
    }

    String getName() {          // 代码7
        return name;
    }

    void outAge() {
        System.out.println(age); // 原题写的 a，应为 age
    }

    void outName() {            // 代码8
        System.out.println(name);
    }
}

public class Ans_FillClassA {
    public static void main(String[] args) {
        A cat = new A();
        A dog = new A(10, "wangwang"); // 代码9
        cat.setAge(5);
        cat.setName("miaomiao");       // 代码10
        dog.setAge(15);                // 代码11
        cat.outAge();                  // 代码12
        cat.outName();                 // 代码13
        dog.outAge();                  // 代码14
        dog.outName();                 // 代码15
    }
}
