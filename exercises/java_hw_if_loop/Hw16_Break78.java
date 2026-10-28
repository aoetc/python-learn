/** 16. 从 1 数到 78 就 break。 */
public class Hw16_Break78 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            if (i == 78) {
                break;
            }
        }
    }
}
