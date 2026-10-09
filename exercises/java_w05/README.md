# Java W05 · 继承 extends

对应阶段 **B**。  
测验：`notes/java_w05_测验_继承.md`（Ex 做完再做）

---

## 学什么

1. **继承**：子类用 `extends` 继承父类，自动拥有父类的字段和方法  
2. **`super`**：调用父类构造 / 父类方法  
3. 先会写「学生 → 大学生」这种一条链；覆盖（override）下一小节细讲，本周只轻碰

---

## 练习

| 文件 | 题目 |
|------|------|
| `Ex01Extends.java` | `Person` ← `Student`，子类多用父类的 `name` + 自己的 `score` |
| `Ex02Super.java` | 子类构造里用 `super(...)` 初始化父类部分 |
| `Ex03OverrideIntro.java` | 子类重写 `show()`（覆盖入门） |

IDEA Open 本目录；只 Run 带 `main` 的 `Ex0x...`。
