# 第 12 天测验：错误处理（try / except）

学完廖雪峰 **错误处理**（try/except）后做。  
编程题在 `exercises/lesson12/`。算法加分：二分查找可放 `algo/`（有余力再做）。

---

## 〇、先过一遍（做题前看）

### 为什么要学这个

用户乱输入、文件不存在时，程序常会**直接崩溃**。  
`try/except` = **先试着做；出问题就走备用方案，别整段闪退。**

### 最小写法（今天只记这一种）

```python
try:
    score = int(input("分数："))
except ValueError:
    print("请输入整数")
```

- `try`：可能出错的代码放这里  
- `except ValueError`：捕获「不能转成整数」这类错误  
- 还可以 `except Exception`（太宽，第一遍少用）；或写成：

```python
try:
    score = int(input("分数："))
except ValueError:
    print("请输入整数")
else:
    print("合法：", score)   # 没出错才执行
```

`finally`：不论成没成功都会跑（关文件时有用）——**今天了解即可**。

### 和 if 的差别

| | 含义 |
|--|------|
| `if` | 你自己判断条件 |
| `try/except` | 系统已经报错了，你接住它 |

转 `int` 时，不知道用户会不会输入 `"abc"` → 用 try/except。

### 今天不做的

- 自己 `raise` 抛异常（看懂即可）  
- 很复杂的异常继承树  

看完再做题。参考答案在文末，**做完再看**。

---

## 一、选择题（每题单选）

**1.** `try/except` 主要用来？

- A. 让程序跑得更快
- B. 捕获错误，避免直接崩溃
- C. 定义函数
- D. 创建 list

**2.** `int("abc")` 通常会触发哪类错误？

- A. `ValueError`
- B. `NameError`
- C. `IndentationError`
- D. 不会报错，得到 0

**3.** 下面哪段能在输入非数字时不闪退？

- A. `score = int(input())` 不管输什么
- B. `try: score = int(input())\nexcept ValueError: print("输错了")`
- C. `score = input()` 再直接当整数用
- D. `except: int(input())`

**4.** `else` 和 `try` 一起用时，正确的是？

- A. 只要有 except 就会执行 else
- B. **try 成功、没进 except** 时才执行 else
- C. else 必须写在 except 前面
- D. else 和 if 的 else 完全无关且不能用

**5.** 关于 `finally`，正确的是？

- A. 只有成功才执行
- B. 只有失败才执行
- C. 成功或失败都常会执行（适合做清理）
- D. 必须和 for 一起用

**6.** `input()` 读到的类型默认是？

- A. `int`
- B. `str`
- C. `float`
- D. `bool`

**7.** 用户输入 `60`，`int(input())` 的结果是？

- A. `"60"`
- B. `60`
- C. `60.0`
- D. 报错

**8.** 下面说法正确的是？

- A. 有了 try/except 就再也不需要 if
- B. try 里面代码越少、越精确越好抓错误
- C. except 可以不写任何错误类型，且永远是最佳写法
- D. try 只能包一行 print

---

## 二、判断题（对 / 错）

**1.** `try` 里放可能出错的代码，`except` 里放出错后的处理。

**2.** `int("12.5")` 一定成功得到整数 12。

**3.** 捕获 `ValueError` 以后，程序还可以继续往下跑（取决于你怎么写）。

**4.** 所有错误都应该用 `except:` 一网打尽，什么都不写类型。

**5.** `finally` 里适合做「一定要做的收尾」（了解即可）。

**6.** 错误处理和递归是同一章必须一起学完的内容。

---

## 三、编程题（`exercises/lesson12/`）

| 文件 | 练什么 |
|------|--------|
| `ex01_safe_int.py` | input → int，输错不崩溃 |
| `ex02_safe_div.py` | 除法，除数为 0 时提示 |
| `ex03_retry_score.py` | 加分：输错了允许再试，直到成功 |

可选算法：力扣 **704. 二分查找**（有序数组），有余力再做，不挡今天主线。

做完把选择、判断和编程发我改。

---

## 参考答案（做完再看）

<details>
<summary>选择题</summary>

1. B  2. A  3. B  4. B  5. C  6. B  7. B  8. B

</details>

<details>
<summary>判断题</summary>

1. 对  2. 错  3. 对  4. 错  5. 对  6. 错

</details>
