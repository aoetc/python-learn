# 第 20 天实操：add 写入 CSV

今天在 `dca-ledger` 里做出 **add**：问你日期和金额，**追加一行**到 CSV 文件。  
还不做 `list`（第 21 天）。

---

## 〇、CSV 是什么（1 分钟）

就是普通文本，长这样：

```text
date,amount
2026-09-17,100
2026-09-18,50
```

- 第一行常常是表头：`date,amount`  
- 后面每一行一笔账：日期和金额用**英文逗号**隔开  
- 用你第 13 天会的 `open` + `"a"`（追加）+ `write` 就能写

今天文件路径约定：

```text
dca-ledger/data/ledger.csv
```

（`data/` 文件夹已备好。）

---

## 一、今天验收标准

在 `dca-ledger` 目录下运行：

```bash
cd ~/Developer/python-learn/dca-ledger
../.venv/bin/python main.py
```

你应能：

1. 选择或进入 **add**  
2. 输入日期（如 `2026-09-17`）和金额（如 `100`）  
3. 打开 `data/ledger.csv`，看到多了一行，例如 `2026-09-17,100`  
4. 再运行一次 add，应是**多一行**，不是把旧的全擦掉  

---

## 二、逐步做（按顺序）

### 步骤 1：改 `main.py` 的思路

保留用法说明也可以。今天核心是加一个 **`add` 流程**：

建议结构（你自己敲，不要整段抄完不思考）：

```text
main():
  打印简短菜单（add / 以后才有 list）
  用 input 读一个命令
  如果是 add → 调用 do_add()
  否则提示「还没做」或「未知命令」

do_add():
  date = input("日期：")
  amount = input("金额：")
  打开 data/ledger.csv，用 "a" 追加写入一行
  打印「已保存」之类提示
```

### 步骤 2：第一次写文件时要想表头

若文件还不存在，最好先写表头再写数据。一种简单做法：

1. 用 `os.path.exists("data/ledger.csv")` 判断文件在不在  
   （先 `import os`）  
2. 不在：用 `"w"` 或 `"a"` 先写一行 `date,amount\n`  
3. 再追加：`f"{date},{amount}\n"`  

也可以：手动先建一个只有表头的 `data/ledger.csv`，程序只负责 `"a"` 追加。两种都行。

### 步骤 3：路径怎么写

在 `dca-ledger` 目录下运行时，相对路径用：

```python
path = "data/ledger.csv"
```

一定要用 **`encoding="utf-8"`**（有中文提示时也稳）。

写入示例形状（自己敲进 `do_add`）：

```python
with open(path, "a", encoding="utf-8") as f:
    f.write(f"{date},{amount}\n")
```

注意行尾的 `\n`，否则两笔会粘在同一行。

### 步骤 4：自测

1. 跑 `main.py` → 选 add → 输入一笔  
2. 用编辑器打开 `data/ledger.csv` 看一眼  
3. 再 add 一笔，确认是两行数据（外加可能有一行表头）  

### 步骤 5：更新 README 一两句

在「怎么运行」下面补：

- 如何 add（运行后输入什么）  
- 数据写在 `data/ledger.csv`  
- 不要提交真实账单（样例可以）

### 步骤 6：做完叫我

说「第 20 天做完了」。我帮你看代码和 `ledger.csv` 长得对不对。  
通过后 Commit + Push。

---

## 三、今天明确不做

- 不做 `list` / `summary`  
- 不用 `pandas`、不用 Excel  
- 不必用 `csv` 模块（想用可以，**`write` 一行也完全够**）  
- 不要 `sys.argv`（第 28 天再做命令行参数）

---

## 四、常见坑

| 现象 | 原因 |
|------|------|
| 每次只剩最后一笔 | 用了 `"w"` 而不是 `"a"` |
| 两笔粘一行 | 忘了 `\n` |
| 找不到文件 | 没在 `dca-ledger` 目录下运行，或 `data/` 不存在 |
| 中文乱码 | 忘记 `encoding="utf-8"` |

---

卡住就把 `main.py` 和报错贴过来；先自己写，我按步提示，不直接代写整份。
