# Java W03 · 类和对象（入门）

对应阶段 **B · OOP 主战场** 第一周。  
进度：`notes/java_学习进度.md`  
测验：`notes/java_w03_测验_类和对象.md`

---

## 本周学什么

1. **类 = 图纸，对象 = 按图纸做出来的实例**
2. **字段**（对象身上的数据）+ **方法**（对象会做的事）
3. **`new`** 创建对象；用 `对象.字段` / `对象.方法()` 使用
4. **构造方法**：`new` 时自动调用，用来初始化

对照 Python：`class Student:` / `s = Student()` 同概念，Java 语法更「啰嗦」一点。

---

## 练习（IDEA Open 本目录）

| 文件 | 做什么 |
|------|--------|
| `Ex01Student.java` | 定义 `Student` 类：姓名、成绩；打印信息 |
| `Ex02Constructor.java` | 用构造方法创建学生 |
| `Ex03This.java` | 用 `this` 区分「字段」和「参数」 |

先看 [`题干.md`](题干.md)，再写代码。

## IDEA 老报「未包含 main 方法」？

每个练习文件里有两个类，例如 `Ex03This`（有 main）和 `Student3`（没有 main）。

- **要对着 `Ex01Student` / `Ex02Constructor` / `Ex03This` 点绿色三角**
- **不要**对着 `Student` / `Student2` / `Student3` 点 Run  
- `new` 和 `.show()` 必须写在 **`main` 的大括号里面**，不能写在文件最外面  

若仍报错：上方菜单 Run → Edit Configurations… → 删掉旧配置 → 再对带 main 的类重新 Run。

