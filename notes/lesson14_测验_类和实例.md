# 第 14 天测验：类和实例

学完廖雪峰 **类和实例**（`class` / `__init__` / `self` / 方法）后做。  
**访问限制、继承、多态第一遍略读即可，本卷不深考。**  
编程题在 `exercises/lesson14/`。

---

## 〇、先过一遍（做题前看，约 5 分钟）

### 类 vs 实例

- **类** = 图纸，例如 `Student`
- **实例** = 按图纸造出来的某一个，例如 `bart = Student("李宏", 90)`

```python
class Student(object):   # Python3 写成 class Student: 也行
    def __init__(self, name, score):
        self.name = name
        self.score = score

    def print_score(self):
        print(f"{self.name}: {self.score}")

bart = Student("李宏", 90)
bart.print_score()
```

### 三个关键词

| 词 | 人话 |
|----|------|
| `__init__` | 造实例时自动跑，做出厂设置 |
| `self` | 当前这个实例；方法第一个参数，调用时不用你传 |
| `self.name = name` | 右边是传来的值，左边贴到这个实例身上 |

### 方法 vs 普通函数

- 普通函数：`print_score(bart)`，自己把实例递进去  
- 方法：写在类里，`bart.print_score()`，`self` 自动就是 `bart`

### 今天不做

- `@property`、大量私有变量细节、多重继承、元类  

看完再做题。参考答案在文末，**做完再看**。

---

## 一、选择题（每题单选）

**1.** `class Student(object): pass` 主要在做什么？B

- A. 立刻造出三个学生
- B. 定义一张叫 Student 的「图纸」（类）
- C. 打开一个文件
- D. 和 `def Student` 完全一样

**2.** `bart = Student("李宏", 90)` 时，`"李宏"` 通常会进到 `__init__` 的哪个参数？A--B

- A. `self`
- B. `name`（`self` 后面的第一个）
- C. 不会进 `__init__`
- D. 只能赋给 `bart.score`

**3.** 调用 `bart.print_score()` 时，方法里的 `self` 是？B

- A. 类 `Student` 本身
- B. 实例 `bart`
- C. 字符串 `"print_score"`
- D. 必须自己写成 `print_score(bart)` 才有 `self`

**4.** `self.name = name` 里，右边的 `name` 是？B

- A. 一定是全局变量
- B. `__init__`（或方法）的参数，外面传进来的值
- C. 另一个类的名字
- D. 只能是整数

**5.** 下面哪个是「实例」？B

- A. `Student`（打印出来带 `class`）
- B. `bart = Student("李宏", 90)` 得到的 `bart`
- C. `def __init__`
- D. `pass`

**6.** 类外面有函数 `def print_score(std): ...`，类里面有方法 `def print_score(self): ...`。对实例 `bart`，推荐怎么调用方法？B

- A. `print_score()` 什么都不传
- B. `bart.print_score()`
- C. `Student.print_score` 不写括号
- D. 只能 `print(bart)`

**7.** 关于 `(object)`，第一遍最合适的理解是？B

- A. 必须每天换一种写法
- B. 老教程常见写法；Python3 写成 `class Student:` 通常也可以
- C. 表示这个类是一个文件
- D. 表示禁止造实例

**8.** 空的类体里写 `pass` 是因为？B

- A. 让程序跑更快
- B. 语法上类里要有内容，暂时空着就占位
- C. 必须写，否则不能有 `__init__`
- D. 和 `return` 相同

---

## 二、判断题（对 / 错）

**1.** 类是图纸，实例是按图纸造出来的具体对象。对

**2.** 写 `Student("李宏", 90)` 时，需要自己把 `self` 当作第一个参数传进去。错

**3.** `bart.name` 是实例 `bart` 身上的属性。对

**4.** 方法的第一个参数习惯叫 `self`，代表当前实例。对

**5.** `print(Student)` 和 `print(bart)` 打印出来的信息含义完全一样。错，但是我不知道print（student）出来是什么东西，是所有实例吗

**6.** 可以把「对学生做的操作」写成类里的方法，用 `实例.方法()` 调用。对

**7.** `__init__` 是造实例时自动调用的初始化方法。对

**8.** 第一遍必须把继承、多态全部学透才能写 `class`。错

---

## 三、编程题（`exercises/lesson14/`）

| 文件 | 练什么 |
|------|--------|
| `ex01_student.py` | `__init__` + 属性 + 方法打印 |
| `ex02_is_pass.py` | 方法里用 `self.score` 判断及格 |
| `ex03_ledger_entry.py` | 小类：日期 + 金额（为以后账本铺垫） |

做完把选择、判断答案和三个文件发我改。

---

## 参考答案（做完再看）

<details>
<summary>选择题</summary>

1. B  2. B  3. B  4. B  5. B  6. B  7. B  8. B

</details>

<details>
<summary>判断题</summary>

1. 对  2. 错  3. 对  4. 对  5. 错  6. 对  7. 对  8. 错

</details>
