/** Manager / TemporaryEmployee + 多态数组涨薪测试 */
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

class TemporaryEmployee extends Employee {
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

public class Self_10_ManagerTemp {
    public static void main(String[] args) {
        Employee[] arr = new Employee[3];
        arr[0] = new Employee("王五", 'M', 30, 5000, "销售");
        arr[1] = new Manager("赵六", 'F', 40, 8000, "管理", "A301");
        arr[2] = new TemporaryEmployee("钱七", 'M', 22, 3000, "后勤", 1);

        for (Employee e : arr) {
            e.raiseSalary(0.10);
        }
        for (Employee e : arr) {
            System.out.println(e);
        }
    }
}
