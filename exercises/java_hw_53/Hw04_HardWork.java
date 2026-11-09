/**
 * 填空4 HardWork
 * 代码1～3：各子类重写 earnings()
 * 代码4：遍历 employee 累加 salaries
 */
abstract class Employee {
    public abstract double earnings();
}

class YearWorker extends Employee {
    public double earnings() {
        return 100000; // 年薪示例
    }
}

class MonthWorker extends Employee {
    public double earnings() {
        return 8000 * 12;
    }
}

class WeekWorker extends Employee {
    public double earnings() {
        return 2000 * 52;
    }
}

class Company {
    Employee[] employee;
    double salaries = 0;

    Company(Employee[] employee) {
        this.employee = employee;
    }

    public double salariesPay() {
        salaries = 0;
        for (int i = 0; i < employee.length; i++) {
            salaries += employee[i].earnings();
        }
        return salaries;
    }
}

public class Hw04_HardWork {
    public static void main(String[] args) {
        Employee[] employee = new Employee[20];
        for (int i = 0; i < employee.length; i++) {
            if (i % 3 == 0) employee[i] = new WeekWorker();
            else if (i % 3 == 1) employee[i] = new MonthWorker();
            else employee[i] = new YearWorker();
        }
        Company company = new Company(employee);
        System.out.println("公司年工资总额：" + company.salariesPay());
    }
}
