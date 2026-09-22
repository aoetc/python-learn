/*
 * ========== 题干 Ex03 ==========
 * 1. 写方法 countPass：统计 >=60 的个数，return int
 * 2. main 里打印及格人数
 * 3. （加练）再打印出「哪些分数及格了」
 * ==============================
 */

public class Ex03CountPass {
    public static void main(String[] args) {
        System.out.println("【Ex03】统计及格人数，并列出及格分数");

        int[] scores = {90, 55, 78, 42, 88};

        int count = countPass(scores);
        System.out.println("及格人数: " + count);

        // 再扫一遍数组：及格的就打印出来
        System.out.print("及格分数: ");
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 60) {
                System.out.print(scores[i] + " ");
            }
        }
    }

    // 返回类型用 int（人数是整数），不要用 double
    public static int countPass(int[] scores) {
        int nums = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 60) {
                nums += 1;
            }
            // else continue 可以不写：不及格就自然进入下一轮
        }
        return nums;
    }
}
