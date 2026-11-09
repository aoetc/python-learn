/** 程序设计5：Manager 继承 Employee（Employee 也在本文件，交作业可一起贴） */
class Employee {
    String name;
    char sex;
    int age;
    double Salary;
    String department;

    Employee(String name, char sex, int age, double Salary, String department) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.Salary = Salary;
        this.department = department;
    }

    double raiseSalary(double proportion) {
        return Salary = Salary * (1 + proportion);
    }

    public String toString() {
        return name + " " + sex + " " + age + " 薪=" + Salary + " 部门=" + department;
    }
}

class Manager extends Employee {
    String officeID;
    double bonus;

    /** 6 个参数：初始化除 bonus 外所有属性 */
    Manager(String name, char sex, int age, double Salary, String department, String officeID) {
        super(name, sex, age, Salary, department);
        this.officeID = officeID;
    }

    void setOfficeID(String officeID) { this.officeID = officeID; }
    String getOfficeID() { return officeID; }
    void setBonus(double bonus) { this.bonus = bonus; }
    double getBonus() { return bonus; }

    /** 在雇员工资涨幅基础上再增加 10% 比例 */
    double raiseSalary(double proportion) {
        return Salary = Salary * (1 + proportion + 0.10);
    }

    public String toString() {
        return super.toString() + " 办公室=" + officeID + " 分红=" + bonus;
    }
}

public class Hw05_Manager {
    public static void main(String[] args) {
        Manager m = new Manager("赵六", 'F', 40, 8000, "管理", "A301");
        m.raiseSalary(0.10);
        System.out.println(m);
    }
}
