/** 递归：100+98+96+…+2+1 */
public class Ans_RecursionSum {
    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    // 从 n 加到 1，每次减 2；若 n 为奇数则最后含 1
    static int sum(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sum(n - 2);
    }
}
