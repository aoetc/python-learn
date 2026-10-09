/*
 * 第2题「修改后能运行」的版本：把 k 声明到与使用范围匹配的位置
 */
public class LX2_2_fixed {
    static int i = 10;

    public static void main(String args[]) {
        int k = 10; // 提到 main 方法范围内，后面都能用
        {
            System.out.println("i=" + i);
            System.out.println("k=" + k);
        }
        System.out.println("i=" + i);
        System.out.println("k=" + k);
    }
}
