# Java W02 测验 · switch 与简单方法

先自己做，做完再来对话对答案。  
**不要把整卷答案先搜一遍。**

---

## 选择

1. 关于 `switch`，错误的是（ C ）  
   A. `case` 后面通常要写 `break`，否则可能继续执行后面的分支  
   B. 可以用 `default` 处理「其它情况」  
   C. `switch` 完全不能代替 `if-else`，两者毫无关系  
   D. 课内常考传统 `switch (x) { case ...: break; }` 写法  

2. 下面哪个是合法的、可被 JVM 当作程序入口的 `main`？（ B ）  
   A. `public void main(String[] args)`  
   B. `public static void main(String[] args)`  
   C. `private static void main(String[] args)`  
   D. `public static int main(String[] args)`  

3. 方法声明 `public static double average(int[] scores)` 中，`double` 表示（ A ）  --B
   A. 参数类型  
   B. 返回值类型  
   C. 类名  
   D. 必须打印到屏幕  

4. 在同一个类里调用 `static` 方法 `average(scores)`，一般（ B ）  
   A. 必须先 `new` 一个对象才能调用  
   B. 可以直接写方法名调用  
   C. 只能在别的文件里调用  
   D. 不能有返回值  

---

## 判断

5. `switch` 里忘记写 `break`，可能出现「穿透」，连续执行多个 `case`。（ 对 ）对 / 错  

6. 有返回值的方法必须用 `return` 给出符合声明类型的值。（ 对 ）对 / 错  

7. `int` 除以 `int` 的结果一定是带小数的 `double`。（ 错 ）对 / 错  

8. 方法的参数列表写在方法名后面的括号里。（ 对 ）对 / 错  存疑：方法是什么意思？调用函数吗

---

## 编程（口答或小片段即可）

9. 用一句话说明：`break` 在 `switch` 里干什么用？  跳出，防止多次处理case ✓

10. 写出方法头（只需一行声明，不必写方法体）：  
    「接收一个 `int` 分数，返回是否及格（`boolean`）」  
    你写：`public static boolean main(int  )` → 有两处要改，见对话讲解

