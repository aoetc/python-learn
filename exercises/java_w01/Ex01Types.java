// 题目：声明变量并打印
//   String name = 你的名字
//   int age = 你的年龄（整数）
//   double height = 身高米数（例如 1.75）
// 用 System.out.println 打印三行，例如：
//   姓名: 李宏
//   年龄: 20
//   身高: 1.75
//
// 运行：
//   javac Ex01Types.java
//   java Ex01Types
//
// 对照 Python：name / age 赋值 + print；注意 Java 必须先写类型。

public class Ex01Types {
    public static void main(String[] args) {
        String name="li";
        int age=20;
        double height=1.8;
        System.out.println("姓名:"+name);
        System.out.println("年龄:"+age);
        System.out.println("高度:"+height);

    }
}
