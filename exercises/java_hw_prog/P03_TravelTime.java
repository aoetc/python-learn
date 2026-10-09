/*
 * 题3：旅程时间
 * 总距离 totalDistance = 183.67（公里）
 * 平均速度 averageSpeed = 58（公里/小时）
 * elapsedTime = totalDistance / averageSpeed
 * 打印所需时间（小时）
 *
 * 提示：用 double，不要用 int 去除法
 */
public class P03_TravelTime {
    public static void main(String[] args) {
        double totalDistance=183.67;
        int averageSpeed=58;
        double elapsedTime=totalDistance/averageSpeed;
        System.out.printf("需要 %.2f小时",elapsedTime);
    }
}
