# 第 17 天测验：JSON（对应小白今日第 17 天）

学完廖雪峰 **IO 编程 → 序列化** 里的 JSON 部分后做。  
（`pickle`、class 转 JSON 进阶看懂即可，本卷不深考。）  
编程题在 `exercises/lesson15/`。

---

## 〇、先过一遍（做题前看）

### 为什么要学这个

程序里的 dict 关掉就没了。想留给下次、或给别的程序/网页用，常存成 **JSON 文字**。  
JSON 长得像 dict，但是 **字符串**。

### 最小写法（今天只记这一种）

```python
import json

d = {"name": "李宏", "score": 90}

s = json.dumps(d)      # dict → 字符串
print(s)               # '{"name": "李宏", "score": 90}'
print(type(s))         # <class 'str'>

d2 = json.loads(s)     # 字符串 → dict
print(d2["name"])      # 李宏
```

写文件 / 读文件：

```python
with open("exercises/lesson15/demo.json", "w", encoding="utf-8") as f:
    json.dump(d, f, ensure_ascii=False)

with open("exercises/lesson15/demo.json", "r", encoding="utf-8") as f:
    data = json.load(f)
print(data)
```

### 名字怎么记

| 名字 | 意思 |
|------|------|
| `dumps` | dump + **s**tring → 倒成**字符串** |
| `loads` | load + **s**tring → 从**字符串**装回来 |
| `dump` | 倒进**文件** |
| `load` | 从**文件**装回来 |

### 和「看起来像」的差别

- `dumps` 前后长得像，但类型不同：前面是 **dict**，后面是 **str**
- dict 能 `d["name"]`；JSON 字符串不能这样取，要先 `loads`

### 今天不做的

- `pickle` 二进制细节  
- 自定义 class 的 `default=` / `object_hook=`（知道「实例不能直接 dumps」即可）

看完再做题。参考答案在文末，**做完再看**。

---

## 一、选择题（每题单选）

**1.** JSON 更接近下面哪一种描述?B

- A. Python 专用的二进制打包格式
- B. 一种通用的文字数据格式，很多语言都能用
- C. 只能用来画图
- D. 和 `if` 一样是关键字

**2.** `json.dumps({"a": 1})` 得到的通常是？B

- A. 一个 dict
- B. 一个 str（JSON 文字）
- C. 一个文件对象
- D. 一个 list

**3.** 要把 JSON 字符串变回 dict，应该用？B

- A. `json.dumps`
- B. `json.loads`
- C. `json.dump`
- D. `open`

**4.** `s = json.dumps(d)` 之后，下面哪句通常会出问题？C,str不能这样用吧

- A. `print(s)`
- B. `print(type(s))`
- C. `print(s["name"])`（假设 d 里有 name）
- D. `d2 = json.loads(s)` 再 `print(d2["name"])`

**5.** 想把 dict 写进 `.json` 文件，更合适的是？A

- A. `json.dumps(d)` 就结束，不用文件
- B. `json.dump(d, f)`（f 是打开的文件）
- C. `f.write(d)` 直接写 dict
- D. `pickle` 是唯一办法

**6.** `json.load(f)` 和 `json.loads(s)` 的主要差别是？A

- A. 一个从文件读，一个从字符串读
- B. 一个只能读数字，一个只能读中文
- C. 完全没有差别，名字随便用
- D. `load` 只能在 Windows 用

**7.** 关于 `pickle` 和 `json`，更准确的是？B

- A. 两者完全一样，可以互换
- B. pickle 偏 Python 专用；JSON 更通用
- C. JSON 是二进制，pickle 是明文
- D. 学了 JSON 就永远不能用 dict

**8.** 直接 `json.dumps(某个 Student 实例)` 常常会？B

- A. 一定成功，和 dumps(dict) 一样
- B. 报错或需要额外转换（实例不是 dict）
- C. 自动变成图片
- D. 删除这个 class

---

## 二、判断题（对 / 错）

**1.** `dumps` 把 Python 对象变成 JSON 字符串；`loads` 把 JSON 字符串变回 Python 对象。对

**2.** `json.dumps(d)` 之后，变量类型通常还是 dict。错

**3.** `dump` / `load` 主要和文件打交道；`dumps` / `loads` 主要和字符串打交道。对

**4.** JSON 字符串里键名按规定常用双引号，这和 Python dict 打印时可能看到单引号不是一回事。对

**5.** 有中文写入 JSON 文件时，可以继续用 `encoding="utf-8"`；`ensure_ascii=False` 能让中文在文件里更易读。对

**6.** 今天必须把 class 的 `default=` / `object_hook=` 全部背熟才能用 JSON。错

---

## 三、编程题（`exercises/lesson15/`）

| 文件 | 练什么 |
|------|--------|
| `ex01_dumps_loads.py` | dict ↔ 字符串：`dumps` / `loads` |
| `ex02_dump_load_file.py` | 写入 / 读回 `demo.json` |
| `ex03_update_json.py` | 加分：读 JSON → 改一个字段 → 写回 |

在仓库根目录运行，例如：

```bash
python exercises/lesson15/ex01_dumps_loads.py
```

做完把选择、判断和编程发我改。

---

## 参考答案（做完再看）

<details>
<summary>选择题</summary>

1. B  2. B  3. B  4. C  5. B  6. A  7. B  8. B

</details>

<details>
<summary>判断题</summary>

1. 对  2. 错  3. 对  4. 对  5. 对  6. 错

</details>
