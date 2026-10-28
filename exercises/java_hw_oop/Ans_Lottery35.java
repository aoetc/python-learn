/** 35选7：每注 7 个不重复 1～35 */
import java.util.Random;
import java.util.Scanner;

class Lottery {
    int[] nums = new int[7];
    Random rand = new Random();

    void generate() {
        int count = 0;
        while (count < 7) {
            int n = rand.nextInt(35) + 1;
            boolean dup = false;
            for (int i = 0; i < count; i++) {
                if (nums[i] == n) { dup = true; break; }
            }
            if (!dup) {
                nums[count++] = n;
            }
        }
        // 简单排序好看一点
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 7; j++) {
                if (nums[i] > nums[j]) {
                    int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
                }
            }
        }
    }

    void printTitle() {
        System.out.println("===== 35选7 =====");
    }

    void printData() {
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

public class Ans_Lottery35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("买几注: ");
        int n = sc.nextInt();
        Lottery lot = new Lottery();
        lot.printTitle();
        for (int i = 1; i <= n; i++) {
            System.out.print("第" + i + "注: ");
            lot.generate();
            lot.printData();
        }
        sc.close();
    }
}
