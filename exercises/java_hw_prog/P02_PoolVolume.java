/*
 * 题2：游泳池容积
 * 长 25 米，宽 10 米，深 6 米
 * 容积 volume = 长 * 宽 * 深
 * 打印容积（可带单位说明）
 */
public class P02_PoolVolume {
    public static void main(String[] args) {
        int length=25;
        int width=10;
        int height=6;
        int volume=length*width*height;
        System.out.println("容积是"+volume+"立方米");
    }
}
