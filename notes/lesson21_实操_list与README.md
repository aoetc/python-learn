# 第 21 天实操：list 读 CSV + 更新 README

今天做两件事：

1. 实现 **`list`**：读出 `data/ledger.csv`，把每一行打印出来  
2. 把 **README** 写成别人能跟着跑的三步（add / list / 注意点）

不做合计 `summary`（第 22 天）。

---

## 〇、人话小结

`add` 是往本子里写；`list` 是打开本子念出来。  
还是第 13 天那套：`"r"` + `read` / `readlines`，外加文件不存在时用 `try/except FileNotFoundError`。

路径继续用第 20 天同一套公式（复制即可）：

```python
base = os.path.dirname(os.path.abspath(__file__))
path = os.path.join(base, "data", "ledger.csv")
```

---

## 一、今天验收

运行 `main.py`，输入 `list`：

- 若已有账：屏幕上能看到表头和每一笔（或至少看到每一行文字）  
- 若故意没有文件 / 删掉 csv 测一次：打印友好提示（如「还没有流水」），**不闪退**

README 里能看懂：怎么运行、怎么 add、怎么 list。

---

## 二、逐步做

### 步骤 1：写 `do_list()`（和 `do_add` 平级）

思路：

```text
算出 path（同 do_add）
try:
    用 "r" 打开 path
    读出内容（read 或 readlines 都行）
    print 出来
except FileNotFoundError:
    print("还没有流水，请先 add")
```

最小读法之一：

```python
with open(path, "r", encoding="utf-8") as f:
    print(f.read())
```

或逐行：

```python
with open(path, "r", encoding="utf-8") as f:
    for line in f:
        print(line.strip())
```

### 步骤 2：改菜单

`elif cmd == "list":` 里不要再写「还没做」，改成调用 `do_list()`。

菜单说明也可改成：add / list 都已可用（骨架那句可以删）。

### 步骤 3：自测

1. `list` → 应看到你之前 add 的几笔  
2. 再 `add` 一笔，再 `list`，应多一行  
3. （可选）暂时把 `ledger.csv` 改名/移走，再 `list`，应提示而不是 Traceback  

### 步骤 4：更新 README（三步写清）

请改成大致这样的结构（用你自己的话）：

1. **项目是什么**  
2. **怎么运行**（命令）  
3. **怎么用**  
   - 输入 `add` → 输入日期、金额 → 写入 `data/ledger.csv`  
   - 输入 `list` → 打印全部流水  
4. **注意**：不交 `.venv`；不交真实账单  

删掉「仅脚手架 / list 还没做」这类过时句子。

### 步骤 5：做完叫我

说「第 21 天做完了」，我看 `do_list` + README。通过后 **Commit + Push**。

---

## 三、今天不做

- `summary` 合计  
- 按日期筛选  
- `sys.argv`  
- 拆成多个 .py 文件  

---

## 四、小提示

| 点 | 说明 |
|----|------|
| 路径 | `do_list` 和 `do_add` 用同一套 `base` / `path` |
| `import os` | 可以提到文件最上面一次，两个函数共用 |
| 表头 | `list` 打印整文件时，第一行 `date,money` 一起出来很正常 |

卡住贴 `do_list` 或报错即可。
