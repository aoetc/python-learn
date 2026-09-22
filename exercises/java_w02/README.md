# Java W02 · switch + 简单方法

对应阶段 **A · 地基**（衔接第 2 章语法 → 为第 3 章「方法 / 类」做准备）。

进度：`notes/java_学习进度.md`  
测验：`notes/java_w02_测验_switch与方法.md`（选择/判断只写在该文件，做完再对）

---

## 本周学什么

1. **`switch`**：多分支选择（和一长串 `else if` 同类，写法不同）
2. **方法**：把一段逻辑起名封装；先学 **`static` 方法**（还不用 `new` 对象）
3. **巩固数组**：在方法里接收数组、返回结果

对照 Python：`def` 函数 ≈ Java 的方法；今天先写在**同一个类**的 `main` 旁边。

---

## 练习清单（IDEA Open 本目录）

先看 [`题干.md`](题干.md)，或打开每个 `.java` **文件最上方的题干注释**。

| 文件 | 做什么 |
|------|--------|
| `Ex01Switch.java` | 用 `switch` 按 1–7 打印星期 |
| `Ex02MethodAvg.java` | 写 `static` 方法求数组平均，`main` 里调用 |
| `Ex03CountPass.java` | 写方法统计及格人数（≥60） |

运行时控制台第一行也会打印题目摘要。先自己写到能 Run，再来对话。

---

## 怎么打开

```bash
idea-ce ~/Developer/python-learn/exercises/java_w02
```

或 IDEA：**File → Open** → 选 `exercises/java_w02`。
