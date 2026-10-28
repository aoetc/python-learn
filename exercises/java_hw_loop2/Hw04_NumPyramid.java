/** 4. 数字金字塔：第 i 行打印 i 个 i，前面补空格居中。 */
public class Hw04_NumPyramid {
    public static void main(String[] args) {
        int n = 9;
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
