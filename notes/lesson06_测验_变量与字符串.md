# 第 6 天测验：数据类型和变量 + 字符串和编码

学完廖雪峰 5.1、5.2 后做。编程题在 `exercises/lesson06/` 文件夹里。

---

## 一、选择题（每题单选）

**1.** `type(3.14)` 的结果是？ B

- A. `<class 'int'>`
- B. `<class 'float'>`
- C. `<class 'str'>`
- D. `<class 'bool'>`

**2.** 下面哪个赋值是正确的?C

- A. `name = 李宏`
- B. `name = "李宏"`
- C. `name = '李宏'` 和 B 都对
- D. `int name = 19`

**3.** Python 3 中 `5 / 2` 的值是？B

- A. `2`
- B. `2.5`
- C. `2.0`
- D. 报错

**4.** `5 // 2` 的值是？A

- A. `2`
- B. `2.5`
- C. `3`
- D. `2.0`

**5.** `"5" + "3"` 的结果是？C-B

- A. `8`
- B. `"53"`
- C. `53`
- D. 报错

**6.** 下面哪行 f-string 写法正确？B

- A. `print("我叫{name}")`
- B. `print(f"我叫{name}")`
- C. `print(f"我叫", name)`
- D. `print("f我叫{name}")`

**7.** `len("李宏")` 等于多少？D-A

- A. `2`
- B. `3`
- C. `6`
- D. `4`

**8.** `"你好".encode("utf-8")` 返回的类型是？B

- A. `str`
- B. `bytes`
- C. `int`
- D. `list`

**9.** 下面关于 Python 3 和编码的说法，正确的是？B

- A. 写 `"中文"` 前必须先 `.decode("utf-8")`
- B. 代码里的 `"中文"` 已经是 Unicode 字符串，日常可直接用
- C. `input()` 读到的中文会自动变成 bytes
- D. Python 3 不支持 UTF-8

**10.** 读文本文件时，推荐写法是？B

- A. `open("a.txt")` 不写 encoding
- B. `open("a.txt", encoding="utf-8")`
- C. `open("a.txt", encoding="ascii")`
- D. 只能用二进制 `open("a.txt", "rb")` 读中文

---

## 二、判断题（对 / 错）

**1.** Python 3 里变量赋值前要像 C 一样先声明类型，例如 `int age = 19`。错

**2.** `bool` 类型只有 `True` 和 `False` 两个值（首字母大写）。对

**3.** `float(input("年龄"))` 适合用来读用户的名字。错

**4.** `encode` 是把字符串变成字节，`decode` 是把字节变回字符串。对

**5.** UTF-8 是 Unicode 的一种编码方式，不是 Unicode 本身。对

**6.** `len("你好")` 和 `len("你好".encode("utf-8"))` 在 Python 里一定相等。错

**7.** f-string 是在字符串前加 `f`，用 `{变量名}` 嵌入值。对

**8.** 同一个汉字在 UTF-8 下占用的字节数，一定和英文字母一样都是 1 个字节。错

---

## 三、编程题（在 IDE 里打开 `exercises/lesson06/`）

| 文件 | 要求 |
|------|------|
| `ex01_four_types.py` | 四个变量 + `type()` |
| `ex02_fstring_card.py` | f-string 做一张「名片」 |
| `ex03_encode_roundtrip.py` | encode / decode 往返 |
| `ex04_file_utf8.py` | 写文件再读回来（可选加分） |

每题 `# TODO` 下面写代码，终端运行验证。做完把选择题/判断题答案 + 编程题发我改。

---

## 参考答案（做完再看）

<details>
<summary>点击展开选择题答案</summary>

1. B  2. C  3. B  4. A  5. B  6. B  7. A  8. B  9. B  10. B

</details>

<details>
<summary>点击展开判断题答案</summary>

1. 错  2. 对  3. 错  4. 对  5. 对  6. 错  7. 对  8. 错

</details>
