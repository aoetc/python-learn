// 题目：一维数组求平均、找最大（阶段 A 验收雏形）
//   给定 int[] scores = {90, 85, 78, 92, 88};
//   1) 计算平均值（可用 double），打印：平均分: xx.x
//   2) 找出最大值，打印：最高分: xx
//
// 运行：
//   javac Ex03ArrayAvg.java
//   java Ex03ArrayAvg
//
// 对照 Python：scores = [90, 85, ...]；for x in scores / max(scores)
// 注意：Java 数组长度用 scores.length（没有 len()）

public class Ex03ArrayAvg {
    public static void main(String[] args) {
        int[] scores = {90, 85, 78, 92, 88};
        int sum = 0;
        int max = scores[0]; // 先假定第 0 个最大，再和后面比

        // i < scores.length：有几个数就循环几次（不要写死 i<=4）
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            // 要和「目前的最大值 max」比，不是永远和 scores[0] 比
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        // sum 和 length 都是 int，直接除会丢掉小数；先转 double 再除
        double average = (double) sum / scores.length;
        System.out.println("平均分: " + average);
        System.out.println("最高分: " + max);
    }
}
