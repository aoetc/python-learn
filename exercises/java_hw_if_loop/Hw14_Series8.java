/** 14. 8+88+888+… 前 5 项；顺便算 2+22+222+… */
public class Hw14_Series8 {
    public static void main(String[] args) {
        System.out.println("前5项之和(8开头): " + series(8));
        System.out.println("前5项之和(2开头): " + series(2));
    }

    static int series(int d) {
        int x = d;
        int s = 0;
        int i = 0;
        do {
            s = s + x;
            x = 10 * x + d;
            i++;
        } while (i < 5);
        return s;
    }
}
