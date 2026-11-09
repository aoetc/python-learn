/**
 * 程序设计7：测试题5+6
 * Employee[3] = 普通雇员、Manager、TemporaryEmployee；全体涨 10%；打印
 * （Employee/Manager/TemporaryEmployee 定义在 Hw05、Hw06，本目录一起编译）
 */
public class Hw07_TestEmployees {
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
