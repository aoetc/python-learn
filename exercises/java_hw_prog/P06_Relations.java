/*
 * 题6：从键盘读变量，写关系/逻辑表达式，打印结果（true/false）
 */
import java.util.Scanner;

public class P06_Relations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入年龄: ");
        int age = sc.nextInt();
        System.out.print("请输入体温(华氏): ");
        double tem = sc.nextDouble();
        System.out.print("请输入身高(英尺): ");
        double height = sc.nextDouble();
        System.out.print("请输入字母: ");
        char letter = sc.next().charAt(0);
        System.out.print("请输入工龄: ");
        double yearsWorked = sc.nextDouble();
        System.out.print("请输入长度(英尺): ");
        double length = sc.nextDouble();

        boolean ageCase = (age == 30);
        boolean temCase = (tem > 98.6);
        boolean heightCase = (height < 5);
        boolean letterCase = (letter == 'm');
        boolean ageAndHeightCase = (age == 30 && height > 6);
        boolean ageOrWorkCase = (age > 50 || yearsWorked >= 5);
        boolean lengthCase = (length > 3 && length < 5);

        System.out.println("年龄为30: " + ageCase);
        System.out.println("体温大于98.6: " + temCase);
        System.out.println("身高小于5英尺: " + heightCase);
        System.out.println("字母为m: " + letterCase);
        System.out.println("年龄为30并且身高大于6英尺: " + ageAndHeightCase);
        System.out.println("年龄超过50或者工龄至少5年: " + ageOrWorkCase);
        System.out.println("长度大于3并且小于5英尺: " + lengthCase);

        sc.close();
    }
}
