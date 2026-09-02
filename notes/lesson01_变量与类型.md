# 第 1 课：变量与数据类型

**对应廖雪峰：** [5. Python 基础 → 5.1 数据类型和变量](https://www.liaoxuefeng.com/wiki/1016959663602400/3248765228448730)

先快速看一遍廖雪峰（15 分钟），看不懂没关系，回来做下面的题。

---

## 讲解（用大白话）

### 1. 变量 = 贴标签的盒子

```python
name = "小李"
age = 19
```

- `name`、`age` 是**变量名**（标签）
- `=` 是**赋值**：把右边的值放进左边的名字里
- **不用像 C 那样先声明类型**，Python 自己知道

对照 C 你学过的：

```c
int age = 19;      // C：要先说类型
```

```python
age = 19           # Python：直接写
```

---

### 2. 四种最常用的类型

| 类型 | 例子 | 干什么用 |
|------|------|----------|
| `int` 整数 | `19`, `-3`, `0` | 计数、年龄 |
| `float` 小数 | `3.14`, `98.6` | 价格、温度 |
| `str` 字符串 | `"hello"`, `'杭州'` | 文字，用引号包起来 |
| `bool` 布尔 | `True`, `False` | 对/错，后面 if 用 |

查看类型：

```python
print(type(age))    # <class 'int'>
```

---

### 3. 打印与 f-string（推荐）

```python
name = "宏李"
age = 19
print("我叫", name, "今年", age)           # 多个东西用逗号
print(f"我叫{name}，今年{age}岁")          # f-string，最常用
```

---

### 4. 简单运算

```python
a + b    # 加
a - b    # 减
a * b    # 乘
a / b    # 除，结果总是 float，例如 5/2 = 2.5
a // b   # 整除，5//2 = 2
a % b    # 取余，5%2 = 1
```

---

## 今日作业

打开 `exercises/lesson01/` 里 5 个文件，**每个文件顶部有题目**，在 `# TODO` 下面写代码。

全部写完后终端逐个运行，例如：

```powershell
python exercises/lesson01/ex01_name_age.py
```

都能跑通 → GitHub Desktop Commit：`Complete lesson01 exercises` → 来 chat 说「第 1 课做完了」，我帮你改。

---

## 自检清单

- [ ] 能解释：变量、赋值、`type()` 是干什么的
- [ ] 会用 f-string 打印一句话
- [ ] 5 个 ex 文件都能运行出题目要求的结果
