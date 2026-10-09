/*
 * 题1：length=16, width=18
 * 用赋值：perimeter = 2*length + 2*width
 * 再打印 perimeter
 *
 * 注意：书上写 2length 在 Java 里非法，必须 2 * length
 */
public class P01_Perimeter {
    public static void main(String[] args) {
        int length=16;
        int width=18;
        int perimeter=2*length+2*width;
        System.out.println("周长是:"+perimeter);
    }
}
