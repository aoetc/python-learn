/**
 * 简答9：同一个类里，不论 public/protected/private/默认，都可以直接访问。
 * 交作业：贴代码 + 说明「同类内 private 也能用」。
 */
public class Hw09_AccessSameClass {
    public long id;
    protected String name;
    private char sex;
    int age;

    public String toString() {
        return id + name + sex + age;
    }

    public static void main(String[] args) {
        Hw09_AccessSameClass s1 = new Hw09_AccessSameClass();
        s1.id = 20110010L;
        s1.name = "zhangshan";
        s1.sex = 'M';
        s1.age = 20;
        System.out.println(s1);
        System.out.println("结论：同类内四种权限都能直接调用。");
    }
}
