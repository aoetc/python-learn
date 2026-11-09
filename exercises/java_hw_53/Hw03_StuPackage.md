# 填空3：包 com 中的 Stu

交作业按空填写（完整类如下）：

```java
package com;                                    // (1)

public class Stu {
    public static final String classid = "001"; // (2) 字符串常量
    public static String school = "YEU";         // (3) 类变量

    private int age;
    public String id;
    public String name;

    public Stu(String ids, String names) {       // (4)
        id = ids;
        name = names;
    }

    public static String getSchool() {           // (5)
        return school;
    }

    public static void main(String[] args) {
        System.out.println(Stu.getSchool());
        System.out.println(Stu.school);
    }
}
```

说明：文件要放在 `com/Stu.java`，用 `javac com/Stu.java` 再 `java com.Stu` 跑。  
本目录为交作业方便写成 md；需要可运行版见 `Hw03_Stu.java`（无 package，方便 IDEA 直接 Run）。
