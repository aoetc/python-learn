/*
 * 原题：下面最后一行会编译失败（k 出了作用域）。
 * 先理解错误，再看 LX2_2_fixed.java 的改法。
 *
 * 若要「按书上原样」体会报错：把下面「会出错的那行」取消注释再编译。
 */
public class LX2_2 {
    static int i = 10;

    public static void main(String args[]) {
        {
            int k = 10;
            System.out.println("i=" + i);
            System.out.println("k=" + k);
        }
        System.out.println("i=" + i);
        // System.out.println("k=" + k); // 编译出错：k 只在上面的 { } 里有效
        System.out.println("（块外不能再用 k，已注释掉出错行）");
    }
}
