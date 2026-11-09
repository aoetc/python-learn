/** 交作业对照用：Self_10 的完整参考（先自己写再看） */
class Emp {
    String name;
    char sex;
    int age;
    double Salary;
    String department;

    Emp(String name, char sex, int age, double Salary, String department) {
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

class Manager extends Emp {
    String officeID;
    double bonus;

    Manager(String name, char sex, int age, double Salary, String department, String officeID) {
        super(name, sex, age, Salary, department);
        this.officeID = officeID;
    }

    void setOfficeID(String officeID) { this.officeID = officeID; }
    String getOfficeID() { return officeID; }
    void setBonus(double bonus) { this.bonus = bonus; }
    double getBonus() { return bonus; }

    double raiseSalary(double proportion) {
        return Salary = Salary * (1 + proportion + 0.10);
    }

    public String toString() {
        return super.toString() + " 办公室=" + officeID + " 分红=" + bonus;
    }
}

class TemporaryEmployee extends Emp {
    int hireYears;

    TemporaryEmployee(String name, char sex, int age, double Salary, String department, int hireYears) {
        super(name, sex, age, Salary, department);
        this.hireYears = hireYears;
    }

    void setHireYears(int hireYears) { this.hireYears = hireYears; }
    int getHireYears() { return hireYears; }

    double raiseSalary(double proportion) {
        return Salary = Salary * (1 + proportion * 0.5);
    }

    public String toString() {
        return super.toString() + " 雇佣年限=" + hireYears;
    }
}

public class Ans_10_ManagerTemp_参考 {
    public static void main(String[] args) {
        Emp[] arr = new Emp[3];
        arr[0] = new Emp("王五", 'M', 30, 5000, "销售");
        arr[1] = new Manager("赵六", 'F', 40, 8000, "管理", "A301");
        arr[2] = new TemporaryEmployee("钱七", 'M', 22, 3000, "后勤", 1);

        for (Emp e : arr) e.raiseSalary(0.10);
        for (Emp e : arr) System.out.println(e);
    }
}
