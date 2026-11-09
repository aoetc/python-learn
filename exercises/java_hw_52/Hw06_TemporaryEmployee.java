/** 程序设计6：TemporaryEmployee（依赖同包 Hw05 里的 Employee；单独交可把 Employee 一并贴上） */
class TemporaryEmployee extends Employee {
    int hireYears;

    TemporaryEmployee(String name, char sex, int age, double Salary, String department, int hireYears) {
        super(name, sex, age, Salary, department);
        this.hireYears = hireYears;
    }

    void setHireYears(int hireYears) { this.hireYears = hireYears; }
    int getHireYears() { return hireYears; }

    /** 临时工涨幅 = 正式雇员的 50% */
    double raiseSalary(double proportion) {
        return Salary = Salary * (1 + proportion * 0.5);
    }

    public String toString() {
        return super.toString() + " 雇佣年限=" + hireYears;
    }
}

public class Hw06_TemporaryEmployee {
    public static void main(String[] args) {
        TemporaryEmployee t = new TemporaryEmployee("钱七", 'M', 22, 3000, "后勤", 1);
        t.raiseSalary(0.10);
        System.out.println(t);
    }
}
