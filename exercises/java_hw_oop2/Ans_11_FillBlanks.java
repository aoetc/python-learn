/**
 * 填空题答案汇总（AbstractTest / Student接口 / Stu包 / HardWork）
 * 下面可直接运行 HardWork 部分；填空原文对照见注释。
 */

// ========== 填空1 AbstractTest ==========
// (1) public abstract void printMsg();
// (2) class DefaultTest extends AbstractTest
// (3) DefaultTest(String name, String id, int score) { this.name=name; this.id=id; this.score=score; }
// (4) DefaultTest(String name, String id) { this(name, id, 0); } 或分别赋值
// (5) public void printMsg() { System.out.println(name + " " + score); }

// ========== 填空2 接口 Student ==========
// (1) void prtMsg();
// (2) class College implements Student
// (3) private String id; private String name;
// (4) College(String id, String name) { this.id=id; this.name=name; }
// (5) public void prtMsg()

// ========== 填空3 包 com 中的 Stu ==========
// (1) package com;
// (2) public static final String classid = "....";  // 或 final String classid=".."
// (3) public static String school = "YEU";
// (4) public Stu(String ids, String names)
// (5) public static String getSchool()

abstract class EmployeePay {
    public abstract double earnings();
}

class YearWorker extends EmployeePay {
    public double earnings() { // 代码1：按年，举例一年 100000
        return 100000;
    }
}

class MonthWorker extends EmployeePay {
    public double earnings() { // 代码2：月薪*12，举例月 8000
        return 8000 * 12;
    }
}

class WeekWorker extends EmployeePay {
    public double earnings() { // 代码3：周薪*52，举例周 2000
        return 2000 * 52;
    }
}

class Company {
    EmployeePay[] employee;
    double salaries = 0;

    Company(EmployeePay[] employee) {
        this.employee = employee;
    }

    public double salariesPay() {
        salaries = 0;
        for (int i = 0; i < employee.length; i++) { // 代码4
            salaries += employee[i].earnings();
        }
        return salaries;
    }
}

public class Ans_11_FillBlanks {
    public static void main(String[] args) {
        EmployeePay[] employee = new EmployeePay[20];
        for (int i = 0; i < employee.length; i++) {
            if (i % 3 == 0) employee[i] = new WeekWorker();
            else if (i % 3 == 1) employee[i] = new MonthWorker();
            else employee[i] = new YearWorker();
        }
        Company company = new Company(employee);
        System.out.println("公司年工资总额：" + company.salariesPay());

        // 顺带演示填空1、2
        DefaultTest dt = new DefaultTest("张三", "001", 90);
        dt.printMsg();
        College col = new College("002", "李四");
        col.prtMsg();
    }
}

abstract class AbstractTest {
    public abstract void printMsg();
}

class DefaultTest extends AbstractTest {
    String name;
    String id;
    int score;

    DefaultTest(String name, String id, int score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    DefaultTest(String name, String id) {
        this(name, id, 0);
    }

    public void printMsg() {
        System.out.println(name + " " + score);
    }
}

interface StudentIf {
    void prtMsg();
}

class College implements StudentIf {
    private String id;
    private String name;

    College(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void prtMsg() {
        System.out.println(id + name);
    }
}
