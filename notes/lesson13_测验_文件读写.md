# 第 13 天测验：文件读写

学完廖雪峰 **文件读写**（`open` / `with` / `read` / `write`）后做。  
编程题在 `exercises/lesson13/`。

---

## 〇、先过一遍（做题前看）

### 为什么要学这个

程序关掉，变量就没了。想把名字、分数留下来，就要写进**文件**；下次再打开读回来。

### 最小写法（今天只记这一种）

```python
with open("exercises/lesson13/demo.txt", "w", encoding="utf-8") as f:
    f.write("李宏\n")

with open("exercises/lesson13/demo.txt", "r", encoding="utf-8") as f:
    text = f.read()
print(text)
```

- `with open(...) as f`：打开本子，用完**自动合上**（比自己 `close()` 省心）
- `"w"`：写。文件没有就新建；**有就会把旧内容清空再写**
- `"r"`：读（默认就是读，也可以不写 `"r"`）
- `"a"`：追加，旧的还在，新的接在后面
- `encoding="utf-8"`：有中文就写上，避免乱码
- `f.read()`：一次读出全部，得到**一个字符串**
- `f.readlines()`：按行切成 **list**，每一行是一个字符串

### 和昨天 try/except 怎么拼

文件不存在时去 `"r"`，会 `FileNotFoundError`。可以包一层：

```python
try:
    with open("没有这个文件.txt", "r", encoding="utf-8") as f:
        print(f.read())
except FileNotFoundError:
    print("文件不存在")
```

### 今天不做的

- 二进制、`pickle`、`StringIO`
- `os.path` / `pathlib` 深挖（以后项目再用）

看完再做题。参考答案在文末，**做完再看**。

---

## 一、选择题（每题单选）

**1.** `with open(...) as f` 主要好处是？B

- A. 程序跑得更快
- B. 用完自动关闭文件
- C. 可以不写文件名
- D. 自动把数字加成 1

**2.** 有中文时，推荐加上？这个倒是真的不是很清楚，应该是B-A

- A. `encoding="utf-8"`
- B. `encoding="gbk"` 每天必须换
- C. 什么都不写，中文会自己消失
- D. `encoding=utf8` 不带引号

**3.** 已有文件 `a.txt` 里是 `旧`。执行 `open("a.txt", "w", encoding="utf-8")` 再 `write("新")`，文件里通常是？B

- A. `旧新`
- B. `新`（旧的被清空）
- C. 报错，不能写已有文件
- D. `旧`

**4.** 想保留旧内容、在末尾加一行，模式应选？C

- A. `"w"`
- B. `"r"`
- C. `"a"`
- D. `"int"`

**5.** `f.read()` 得到的通常是？B,就是全部都读取，应该是一大串字符串，但是我有个疑问，文件里面肯定是有换行，标点，那如果不写.stripe，其实就是什么什么，什么什么\n这样的模式吗

- A. 一个 int
- B. 一个字符串
- C. 一个 set
- D. 一个函数

**6.** `f.readlines()` 更接近？B

- A. 一个数字
- B. 按行切开的 list
- C. 只能读第一行，后面永远读不到
- D. 自动删除文件

**7.** `open("没有.txt", "r")` 且这个文件确实不存在，常见结果是？B

- A. 得到空字符串，不报错
- B. `FileNotFoundError`
- C. `ValueError`
- D. 自动创建空文件再读

**8.** `f.write(60)` 直接写整数 60，第一遍更可能？存疑，提问：文件里面一定默认的是str吗

- A. 一定成功，文件里出现 60
- B. 报错（`write` 要的是字符串，可先 `str(60)`）
- C. 自动变成 list
- D. 变成 `"r"` 模式

---

## 二、判断题（对 / 错）

**1.** 读中文文本文件时，写上 `encoding="utf-8"` 是稳妥做法。对，可不写吧

**2.** `"w"` 和 `"a"` 效果完全一样，都不会清空旧内容。错

**3.** `with` 用完一般会关文件，不必每次自己记得 `close()`。对

**4.** 变量 `name = "李宏"` 在程序结束之后，一定还在硬盘某个文件里。错

**5.** 可以用昨天的 `try/except` 接住「文件不存在」。DUI

**6.** `f.read()` 和 `f.readlines()` 是同一个东西的两种写法，得到的类型也一样。错

---

## 三、编程题（`exercises/lesson13/`）

在仓库根目录运行，例如：

```text
python exercises/lesson13/ex01_write_read.py
```

| 文件 | 练什么 |
|------|--------|
| `ex01_write_read.py` | `"w"` 写入再 `"r"` 读回 |
| `ex02_read_names.py` | 读现成的 `names.txt`，逐行打印，再打印行数 |
| `ex03_append_or_missing.py` | `"a"` 追加一行；文件不存在时自己处理（提示里有两种做法） |

做完把选择、判断和编程发我改。

---

## 参考答案（做完再看）

<details>
<summary>选择题</summary>

1. B  2. A  3. B  4. C  5. B  6. B  7. B  8. B

</details>

<details>
<summary>判断题</summary>

1. 对  2. 错  3. 对  4. 错  5. 对  6. 错

</details>
