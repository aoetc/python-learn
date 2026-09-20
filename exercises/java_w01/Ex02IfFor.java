// 题目：
// 1) 给定 int score（自己改数字试），用 if-else 打印等级：
//      >= 90 → 优秀
//      >= 60 → 及格
//      否则  → 不及格
// 2) 用 for 打印 1 到 5（每个数字一行）
//
// 运行：
//   javac Ex02IfFor.java
//   java Ex02IfFor
//
// 对照 Python：if/elif/else；for i in range(1, 6)
// 注意：Java for 写法是 for (int i = 1; i <= 5; i++)

public class Ex02IfFor {
    public static void main(String[] args) {
        int score = 85;
        if (score>= 90 ){
            System.out.println("优秀");
        }else if(score>=60){
            System.out.println("及格");
        }else{
            System.out.println("不及格");
        }
        for (int i=1;i<=5;i++){
            System.out.println(i);
        }
    }
}
