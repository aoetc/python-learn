/** Professor 类 + 测试 */
class Professor {
    String name, sex, course;
    int age, result; // 1优 2良 3一般 4差

    Professor(String name, String sex, int age, String course) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.result = 3;
    }

    void setCourse(String course) { this.course = course; }
    String getCourse() { return course; }

    boolean setResult(int result) {
        if (result >= 1 && result <= 4) {
            this.result = result;
            return true;
        }
        return false;
    }

    int getResult() { return result; }

    String getDetails() {
        return "姓名:" + name + " 性别:" + sex + " 年龄:" + age + " 课程:" + course;
    }
}

public class Ans_Professor {
    public static void main(String[] args) {
        Professor p = new Professor("张老师", "男", 40, "Java");
        System.out.println(p.getDetails());
        System.out.println("设置result=1: " + p.setResult(1));
        System.out.println("设置result=9: " + p.setResult(9));
        System.out.println("当前result: " + p.getResult());
    }
}
