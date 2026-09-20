# Java W01 · 环境 + Hello World + 语法起步

对应阶段 **A · 地基**。目标：本机能编译运行 Java，并完成下面 3 道小练习。

进度勾选：`notes/java_学习进度.md`  
卡壳记录：`notes/java_错题与存疑.md`

---

## 0. 环境状态（本机已就绪）

| 项 | 状态 |
|----|------|
| JDK | **Temurin 25** 已装好（`java -version` / `javac -version` 有输出即可） |
| IDE | **IntelliJ IDEA CE** 已装（`/Applications/IntelliJ IDEA CE.app`） |
| 项目 | 本目录已配好，可用 IDEA 直接打开 |

以后换新电脑再重装 JDK；版本 17 / 21 / 25 学这门课都行。

---

## 方式 A · 终端

```bash
cd exercises/java_w01
javac HelloWorld.java
java HelloWorld
```

应打印：`Hello, Java!`

---

## 方式 B · IntelliJ IDEA（已帮你配好）

1. 打开 **IntelliJ IDEA CE**（若没自动弹出项目：菜单 **File → Open…** → 选本文件夹  
   `python-learn/exercises/java_w01`）
2. 若问 Trust Project / 信任项目 → 选 **Trust**
3. 第一次可能提示配置 JDK：选 **temurin-25**  
   （路径一般是 `/Library/Java/JavaVirtualMachines/temurin-25.jdk`）
4. 左侧点开 `HelloWorld.java` → 类名旁绿色三角 **Run**，或右键 → Run `HelloWorld.main()`
5. 底下 Run 窗口出现 `Hello, Java!` 即成功
6. 同样方式运行 `Ex01Types` / `Ex02IfFor` / `Ex03ArrayAvg`（先写完 TODO）

命令行也可随时打开本项目：

```bash
idea-ce ~/Developer/python-learn/exercises/java_w01
```

课上若强制用 Eclipse，到作业需要时再装；自学阶段用 IDEA 即可。

---

## 本周练习清单

| 文件 | 做什么 | 建议对照 Python |
|------|--------|-----------------|
| `HelloWorld.java` | 跑通即可 | `print(...)` |
| `Ex01Types.java` | 变量与类型 | lesson06 变量 |
| `Ex02IfFor.java` | `if` + `for` | lesson07/08 |
| `Ex03ArrayAvg.java` | 一维数组求平均、找最大 | list + 循环 |

每题顶部有说明；把 `// TODO` 换成你的代码。  
**先自己写到能编译**，再来对话里问；不要空文件直接要答案。

---

## 做完怎么勾

1. 四个文件都能跑通（终端或 IDEA 均可）  
2. 打开 `notes/java_学习进度.md`，勾阶段 A：JDK、IDE、HelloWorld  
3. Commit + Push（双机同步）

下一周（仍属阶段 A）：更多数组 / `switch` / 简单方法，为第 3 章「类」做准备。
