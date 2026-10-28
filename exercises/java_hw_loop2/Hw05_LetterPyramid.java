/** 5. 字母金字塔 A～E（居中） */
public class Hw05_LetterPyramid {
    public static void main(String[] args) {
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            char zimu = (char) ('A' + i - 1);
            int num = 2 * i - 1;

            for (int s = 1; s <= rows - i; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= num; j++) {
                System.out.print(zimu);
            }
            System.out.println();
        }
    }
}
