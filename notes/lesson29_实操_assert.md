# 第 29 天实操：小测试 `assert`

今天不学新语法大章。目标：给账本里「拆一行 / 加金额」写 **2～3 个 assert**，跑通再改功能。

编程在 `exercises/lesson29/`（先练纯函数；练熟了再考虑挪进 `dca-ledger`）。

---

## 〇、先过一遍（做题前看）

### `assert` 是什么（人话）

一句话：**我假定这件事一定成立；如果不成立，立刻报错停下来。**

```python
assert 1 + 1 == 2
assert float("80") == 80.0
```

条件为 `True` → 什么都不打印，继续往下跑。  
条件为 `False` → 抛出 `AssertionError`，告诉你「假设破了」。

### 和 `if` / `try` 别混

| | 给谁用 | 干什么 |
|--|--------|--------|
| `if` | 程序逻辑 | 正常分支（比如用户选 add 还是 list） |
| `try/except` | **用户/环境**出错时 | 接住坏输入、文件不存在，别整段闪退 |
| `assert` | **你自己写代码时** | 检查「我以为对的东西」是不是对 |

记法：`assert` = 开发期小哨兵；正式给用户跑的「金额无效」仍用第 12 天的 `try/except`。

### 最小例子（和账本有关）

假设有个函数：把一行 `"2026-09-22,80"` 拆成日期和金额。

```python
def parse_line(line):
    parts = line.strip().split(",")
    date = parts[0]
    money = float(parts[1])
    return date, money

assert parse_line("2026-09-22,80") == ("2026-09-22", 80.0)
assert parse_line("2026-09-17,100.5")[1] == 100.5
```

再假设合计：

```python
def sum_money(amounts):
    total = 0.0
    for m in amounts:
        total += m
    return total

assert sum_money([80.0, 20.0]) == 100.0
assert sum_money([]) == 0.0
```

跑这个文件：全过 → 安静结束；有一条错 → 报 `AssertionError`，对着那一行改。

### 今天不做的

- `unittest` / `pytest` 框架（知道有就行）  
- 用 `assert` 替代用户输入检查（别把 `assert money > 0` 当成对用户的友好提示）

看完再做下面选择/判断；编程打开 `exercises/lesson29/`。

---

## 一、选择题（每题单选）

**1.** `assert x == 1` 在 `x` 真的是 `1` 时会？

- A. 打印 `True`
- B. 什么都不打印，继续执行
- C. 抛出 `AssertionError`
- D. 进入 `except`

**2.** 用户在菜单里输入了坏金额 `"abc"`，程序里更合适的是？

- A. `assert float(text)`
- B. `try: float(text) except ValueError: 提示`
- C. 只用 `if text == "abc"`
- D. 什么都不做，让它闪退就行

**3.** 下面哪句会触发 `AssertionError`？

- A. `assert 2 * 3 == 6`
- B. `assert "80" == "80"`
- C. `assert float("10") == 10.0`
- D. `assert 1 + 1 == 3`

**4.** 今天写 assert，主要是为了？

- A. 让程序对用户更友好
- B. **检查小函数算得对不对**，改功能前先有哨兵
- C. 替代 `sys.argv`
- D. 必须写进 `main.py` 才能算学过

---

## 二、判断题（对 / 错）

**1.** `assert` 条件为假时，程序会抛 `AssertionError`。

**2.** `try/except` 和 `assert` 用途完全一样，可以随便互换。

**3.** 可以一次写多条 assert，一条失败就停在那条。

**4.** 空列表合计为 `0.0` 也可以用 assert 检查。

---

## 三、编程验收（`exercises/lesson29/`）

在 `parse_and_sum.py` 里完成：

1. `parse_line(line)`：输入一行字符串，返回 `(date, money)`，`money` 为 `float`  
2. `sum_money(amounts)`：对 list 里的金额求和，空 list 返回 `0.0`  
3. 文件末尾至少 **3 条** `assert`（建议：正常一行、带小数、空列表合计）

在仓库根目录跑：

```bash
.venv/bin/python exercises/lesson29/parse_and_sum.py
```

全过 = 无输出或只有你自己的 `print`；有失败 = 对着 AssertionError 改。

可选加分：再加一条「坏行该怎么测」——今天用 assert 测**你已知会成功**的例子即可；坏输入仍留给 `try/except`。

---

## 参考答案（做完再看）

### 选择

1. B  
2. B  
3. D  
4. B  

### 判断

1. 对  
2. 错（一个对用户容错，一个对开发者自检）  
3. 对  
4. 对  
