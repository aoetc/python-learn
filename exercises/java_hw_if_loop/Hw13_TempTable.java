/** 13. 0～100℃ 每 5 度一行。h = c*9/5+32 */
public class Hw13_TempTable {
    public static void main(String[] args) {
        System.out.println("摄氏\t华氏");
        for (int c = 0; c <= 100; c += 5) {
            double h = c * 9.0 / 5 + 32;
            System.out.println(c + "\t" + h);
        }
    }
}
