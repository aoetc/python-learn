/** 12. 1+2+…+100 */
public class Hw12_Sum100 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1到100之和: " + sum);
    }
}
