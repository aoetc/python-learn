/** 18. 1 + 2! + 3! + 4! + 5! */
public class Hw18_FactorialSum {
    public static void main(String[] args) {
        int sum = 0;
        int fact = 1;
        for (int i = 1; i <= 5; i++) {
            fact = fact * i;
            sum = sum + fact;
        }
        System.out.println("前5项之和: " + sum);
    }
}
