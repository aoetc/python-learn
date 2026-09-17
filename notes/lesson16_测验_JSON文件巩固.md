# 第 18 天测验：JSON + 文件巩固（对应小白今日第 18 天）

今天**不新开大章**。把昨天的 JSON 和第 13 天的文件读写拼稳。  
编程题在 `exercises/lesson16/`。

---

## 〇、先过一遍（做题前看）

### 今天只练一件事

手里有一份 **JSON 文件**（里面常常是「字典的列表」）：

1. `"r"` + `json.load` 读出来  
2. 改其中一条（或加一条）  
3. `"w"` + `json.dump` 写回去  

### 最小例子

```python
import json

# 文件里大概长这样：
# [
#   {"name": "李宏", "score": 90},
#   {"name": "王五", "score": 80}
# ]

with open("exercises/lesson16/scores.json", "r", encoding="utf-8") as f:
    rows = json.load(f)          # rows 是 list

rows[0]["score"] = 95            # 改第一条

with open("exercises/lesson16/scores.json", "w", encoding="utf-8") as f:
    json.dump(rows, f, ensure_ascii=False, indent=2)
```

### 还容易混的两处（昨天错过）

| 容易混 | 记住 |
|--------|------|
| `dumps` vs `dump` | 有 **s** → 字符串；无 s → **文件** |
| `"w"` 再 `load` | `"w"` 会清空/覆盖；要读先 `"r"` |

### 列表里的字典怎么改

```python
rows[0]["score"] = 95     # 第 0 条的 score
# 或按名字找：
for row in rows:
    if row["name"] == "李宏":
        row["score"] = 95
```

### 今天不做的

- 新学 CSV、requests、class 高级序列化  
- 廖雪峰里函数式 / 元类 / 线程 / Web 等继续跳过  

看完再做题。参考答案在文末，**做完再看**。

---

## 一、选择题（每题单选）

**1.** 要把 dict（或 list）写进 `.json` 文件，更合适的是？B

- A. 只写 `json.dumps(d)`，不用打开文件
- B. `json.dump(d, f)`（f 是用 `"w"` 打开的文件）
- C. `f.write(d)` 直接写 dict
- D. 只能用 `pickle`

**2.** `json.load(f)` 要求 f 通常是？B

- A. 用 `"w"` 打开的文件
- B. 用 `"r"` 打开的文件
- C. 一个整数
- D. 一个 class 名字

**3.** JSON 文件内容是 `[{"name": "李宏"}, {"name": "王五"}]`，`json.load` 之后得到的类型更接近？A--B

- A. 一个 str
- B. 一个 list（里面是 dict）
- C. 一个 int
- D. 一个函数

**4.** 已有 `rows` 是上面那种 list，想把第一条的 score 改成 95，更合适的是？B

- A. `rows.score = 95`
- B. `rows[0]["score"] = 95`
- C. `rows = 95`
- D. `json.dumps(95)`

**5.** 用 `"w"` 打开已有的 `scores.json` 再立刻 `json.load`，常见结果是？B，我知道选b，但是不知道为什么，解释一下给我

- A. 正常读出旧内容
- B. 容易报错或读到空（`"w"` 会清空）
- C. 自动变成图片
- D. 只能在 Windows 成功

**6.** `ensure_ascii=False` 主要方便什么？A

- A. 让中文在文件里更好读
- B. 让程序跑得更快十倍
- C. 自动创建文件夹
- D. 把 list 变成 set

---

## 二、判断题（对 / 错）

**1.** `dump` / `load` 主要和文件打交道；`dumps` / `loads` 主要和字符串打交道。对

**2.** 读出 list 改完字段后，如果不 `dump` 写回，文件里通常还是旧数据。对

**3.** `rows[0]` 是第一条字典；再写 `rows[0]["name"]` 才能取到名字。对

**4.** 今天必须先背完 class 的 `default=` 才能改 JSON 文件。错

**5.** 文件不存在时用 `"r"` 打开，可以用 `try/except FileNotFoundError` 接住（第 12、13 天练过）。对

---

## 三、编程题（`exercises/lesson16/`）

| 文件 | 练什么 |
|------|--------|
| `ex01_read_list.py` | 读 `scores.json`，打印每个人的 name 和 score |
| `ex02_update_one.py` | 把「李宏」的 score 改成 95，写回，再读确认 |
| `ex03_append_one.py` | 加分：在列表末尾加一条新记录，写回 |

仓库根目录运行，例如：

```bash
python exercises/lesson16/ex01_read_list.py
```

做完把选择、判断标在题号旁（和以前一样），编程发我改。

---

## 参考答案（做完再看）

<details>
<summary>选择题</summary>

1. B  2. B  3. B  4. B  5. B  6. A

</details>

<details>
<summary>判断题</summary>

1. 对  2. 对  3. 对  4. 错  5. 对

</details>
