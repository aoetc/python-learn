/*
 * 2.【自己写】反转正整数各位
 * 例：输入 8735 → 输出 5378（注意：若是 5370 反转可能是 735，前导 0 一般不保留）
 * 思路见对话讲解：%10 取个位，/10 去掉个位
 */
import java.util.Scanner;

public class Hw02_Reverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入正整数");
        int n = sc.nextInt();
        int rev = 0;
        while (n > 0) {
        int digit = n % 10;
        rev = rev * 10 + digit;
        n = n / 10;           }
        System.out.println(rev);
    }
}
