/*
 * 2. 判断闰年
 * 条件：能被4整除但不能被100整除；或能被400整除
 */
public class Hw02_LeapYear {
        check();
    }

    static void check(int year) {
        boolean rule1 = (year % 4 == 0 && year % 100 != 0);
        boolean rule2 = (year % 400 == 0);

        if (rule1 || rule2) {
            System.out.println(year + " 是闰年");
        } else {
            System.out.println(year + " 不是闰年");
        }
    }
}
