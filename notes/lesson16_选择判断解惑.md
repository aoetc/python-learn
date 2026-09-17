# 第 18 天 · 选择/判断解惑（批改后）

## 总评

选择：6 题对 5（第 3 题错）
判断：5 题全对
编程：还没写（ex01/ex02/ex03 仍是空 TODO）

## 选择题对错

1 B 对
2 B 对
3 你选 A，应为 B（见下）
4 B 对
5 B 对（见下解释）
6 A 对

## 判断题：全对

## 第 3 题为什么是 B 不是 A

文件里长这样：

[{"name": "李宏"}, {"name": "王五"}]

最外面是方括号 []，所以 json.load 之后是 Python 的 list。
里面每个 {} 是 dict。

A 的 str 是另一回事：json.dumps(...) 得到的才是字符串。
load 从文件读回来，已经帮你变成 list/dict 了，不是 str。

## 第 5 题：为什么选 B（你问为什么）

打开模式可以想成：

- "r" = 打开本子只看，字还在
- "w" = 打开本子准备重写，一打开先把旧字擦掉

所以：

with open("scores.json", "w", ...) as f:
    data = json.load(f)   # 这时本子已经被擦空了

读空文件 → 常见 JSONDecodeError，或读到空。
正确顺序：先 "r" + load，改完，再另开一次 "w" + dump。

## 接下来

去做 exercises/lesson16/ 三道编程。
做完叫我再批。
