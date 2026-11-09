/**
 * 访问权限三道理解题（同文件演示「同类内都能访问」）。
 *
 * 同包不同类：private 不可见，public/protected/默认可见
 * 不同包非子类：只有 public 成员 + public 类可见；默认类 XueYuan 在别的包 new 不了
 *
 * 交作业时：把题里代码按 package 拆文件；标出哪一行编译报错即可。
 */
public class Ans_09_AccessSameClass {
    public long id;
    protected String name;
    private char sex;
    int age;

    public String toString() {
        return id + " " + name + " " + sex + " " + age;
    }

    public static void main(String[] args) {
        Ans_09_AccessSameClass s1 = new Ans_09_AccessSameClass();
        s1.id = 20110010L;
        s1.name = "zhangshan";
        s1.sex = 'M';   // 同类内：private 也能用
        s1.age = 20;
        System.out.println(s1);

        System.out.println("---口答要点---");
        System.out.println("同包别的类：不能写 s1.sex（private）");
        System.out.println("不同包：不能写 name/age/sex；默认修饰的 XueYuan 类也 new 不了");
        System.out.println("只有 public 的 Student 类和 public 字段 id 在异包直接可见");
    }
}
