/*
 * ========== 题干 Ex02 ==========
 * 1. 编写方法：
 *      public static double average(int[] scores)
 *    作用：计算成绩数组的平均分并 return（注意用 double，避免整除丢小数）
 *
 * 2. 在 main 里调用 average(scores)，打印：
 *      平均分: 86.6
 *    （本组数据 {90,85,78,92,88} 平均应是 86.6）
 *
 * 对照 Python：def average(scores): return sum(scores)/len(scores)
 * ==============================
 */

public class Ex02MethodAvg {
    public static void main(String[] args) {
        System.out.println("【Ex02】写 static 方法 average，计算并打印平均分");

        int[] scores = {90, 85, 78, 92, 88};

        // main 里只「调用」方法，不在这里「定义」方法
        double avg = average(scores);
        System.out.println("平均分: " + avg);
    }

    // 方法写在 main 外面、类的大括号里面
    public static double average(int[] scores) {
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return (double) sum / scores.length; // return 后面要分号
    }
}
