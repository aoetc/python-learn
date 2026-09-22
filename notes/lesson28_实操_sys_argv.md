# 第 28 天实操：命令行参数 `sys.argv`

今天让程序可以这样跑（少问一句「请输入命令」）：

```bash
.venv/bin/python dca-ledger/main.py list
.venv/bin/python dca-ledger/main.py summary
.venv/bin/python dca-ledger/main.py add 2026-09-22 80
.venv/bin/python dca-ledger/main.py find 2026-09-17
```

没有参数时，**仍可保留原来的菜单 + input**（两种都能用）。

今天用 **`sys.argv`** 即可，不必学 `argparse`。

---

## 〇、`sys.argv` 是什么（人话）

你在终端敲的一整串命令，Python 会拆成一个 **list**：

```bash
python dca-ledger/main.py list
```

大约是：

```text
sys.argv[0]  →  "dca-ledger/main.py"   （脚本自己的名字）
sys.argv[1]  →  "list"                 （你写的第一个参数）
```

再如：

```bash
python dca-ledger/main.py add 2026-09-22 80
```

```text
sys.argv[1] → "add"
sys.argv[2] → "2026-09-22"
sys.argv[3] → "80"
```

先 `import sys`，再读这个 list。

---

## 一、今天验收

在仓库根目录：

```bash
.venv/bin/python dca-ledger/main.py list
.venv/bin/python dca-ledger/main.py summary
.venv/bin/python dca-ledger/main.py add 2026-09-22 80
.venv/bin/python dca-ledger/main.py find 2026-09-17
```

- `list` / `summary`：不出现「请输入命令」，直接出结果  
- `add` 带日期和金额：写入成功（金额仍要能 `float`，非法要提示）  
- `find` 带日期：只打印那天  
- **不带参数**再跑一次：还可以走旧菜单（推荐保留）

README 补几行「命令行用法」。

---

## 二、逐步改 `main.py`

### 步骤 1：顶部

```python
import sys
```

（已有 `import os`，再加一行即可。）

### 步骤 2：改 `main()` 怎么拿到命令

思路：

```text
如果 len(sys.argv) >= 2:
    cmd = sys.argv[1]
否则:
    打印菜单
    cmd = input("请输入命令：")
```

后面的 `if cmd == "add":` 等可以先不动。

### 步骤 3：让 add / find 也能吃参数（推荐）

**做法 A（改函数参数，更清晰）：**

```text
do_add(date=None, money=None):
    若 date 是 None：date = input(...)
    若 money 是 None：再 input + float 保护
    ... 后面写文件逻辑不变

main 里：
    if cmd == "add":
        if len(sys.argv) >= 4:
            do_add(sys.argv[2], sys.argv[3])
        else:
            do_add()
```

`find` 类似：有 `sys.argv[2]` 就用，否则再 `input`。

**做法 B：** 只在 `main` 里解析 argv，再改一点点 `do_add`——也可以，别把逻辑写乱即可。

### 步骤 4：参数不够时要友好

例如只写了 `python ... add` 却没有日期金额：

```text
print("用法: python dca-ledger/main.py add 日期 金额")
return
```

### 步骤 5：更新 README

加一小节 **命令行用法**，把上面几条示例命令抄进去。

---

## 三、今天不做

- 完整 `argparse` 教程  
- 拆多文件  
- 改 CSV 格式  

---

## 四、常见坑

| 现象 | 原因 |
|------|------|
| `list index out of range` | 参数个数不够就取了 `sys.argv[2]` |
| 金额报错 | `sys.argv[3]` 是字符串，仍要 `float(...)`，并 `try/except` |
| Run 按钮不好测参数 | 用终端敲完整命令；或临时在调试配置里加 args |

---

## 五、做完

说「第 28 天做完了」。我帮你在终端测几条命令。通过后 Commit + Push。
