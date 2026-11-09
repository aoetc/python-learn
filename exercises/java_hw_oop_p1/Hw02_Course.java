/*
 * 课程类 Course（题里写成 Cource 也可）
 * 字段：cNumber, cName, cUnit
 * static int cTotalNum  —— 每 new 一个对象就 +1
 * 构造：初始化编号、名、学分，并让 cTotalNum++
 * printCourseInfo()：打印课程信息 + 当前一共创建了几门课
 * 测试：112101 / Java程序设计 / 3
 */
public class Hw02_Course {
    public static void main(String[] args) {
        Course c = new Course(112101, "Java程序设计", 3);
        c.printCourseInfo();
    }
}

class Course {
    int cNumber;
    String cName;
    int cUnit;
    static int cTotalNum = 0;

    Course(int cNumber, String cName, int cUnit) {
        this.cNumber = cNumber;
        this.cName = cName;
        this.cUnit = cUnit;
        cTotalNum++;
    }

    void printCourseInfo() {
        System.out.println("课程编号：" + cNumber);
        System.out.println("课程名称：" + cName);
        System.out.println("学分：" + cUnit);
        System.out.println("已创建课程数：" + cTotalNum);
    }
}
