/*
 * 1.【自己写】等差级数
 * 第 i 项（i 从 1 开始）：a + (i - 1) * d
 * a=1, d=3, n=100
 * 用循环：打印每一项，并累加总和
 */
public class Hw01_Series {
    public static void main(String[] args) {
        int a=1;
        int d=3;
        int n=100;
        int sum=0;
        for(int i=1;i<=100;i++){
            int term=a+(i-1)*d;
            System.out.println(term);
            sum=sum+term;
        }
        System.out.println("总和是"+sum);
    }
}
