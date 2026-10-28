/** 8. 2019-12-13 之后下一个黑色星期五（某月13日且周五）。 */
import java.util.Calendar;

public class Hw08_BlackFriday {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        // 从 2019-12-13 的下一天开始找
        cal.set(2019, Calendar.DECEMBER, 14);

        while (true) {
            if (cal.get(Calendar.DAY_OF_MONTH) == 13
                    && cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                int y = cal.get(Calendar.YEAR);
                int m = cal.get(Calendar.MONTH) + 1; // Calendar 月份从 0 起
                int d = cal.get(Calendar.DAY_OF_MONTH);
                System.out.println("下一个黑色星期五: " + y + "年" + m + "月" + d + "日");
                break;
            }
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
