# 第 33 天实操：ledger 拆文件（可读性）

今天**不学廖雪峰新章**。目标：把 `dca-ledger/main.py` 拆出一点结构，**还能按 README 跑通**。

---

## 〇、为什么要拆（人话）

现在路径、读写、菜单全挤在一个 `main.py` 里，能跑，但以后越改越乱。

今天最小目标：

- 新建 **`csv_io.py`**：专门管「账本路径 / 和 CSV 打交道」
- **`main.py`**：只管菜单、命令行、`do_add` 等「业务动作」
- 函数留**一行短注释**（docstring 或 `#` 均可）
- 跑通：菜单 + 命令行（和中检一样）

软设里说过的：**路径只在一处算** → 继续放在 `ledger_path()`，只是文件换地方。

---

## 一、建议拆法（按这个做即可）

### 1. 新建 `dca-ledger/csv_io.py`

先把这些挪过去（从 `main.py` 剪出来）：

- `import os`
- `ledger_path()`（带一句注释：返回账本 CSV 完整路径）

可选加分（有余力再做，不做也能过关）：

- `read_lines()`：打开账本，返回所有行；没有文件就返回 `None` 或让调用方 `try/except`
- `append_row(date, money)`：写一行

今天**至少**要有 `ledger_path` 在 `csv_io.py`。

### 2. 改 `main.py`

顶部：

```python
import sys
from csv_io import ledger_path
```

（如果 `main.py` 里不再直接用 `os`，可以去掉 `import os`。）

`do_add` / `do_list` / `do_summary` / `do_find` / `main` **先留在 main.py**，里面继续调用 `ledger_path()`。

### 3. 怎么运行（注意）

仍在**仓库根目录**：

```bash
.venv/bin/python dca-ledger/main.py list
```

或：

```bash
cd ~/Developer/python-learn/dca-ledger
../.venv/bin/python main.py list
```

`from csv_io import ...` 在「当前工作目录 / 脚本同目录」下要能找到 `csv_io.py`。  
若报 `ModuleNotFoundError: csv_io`：用上面第二种（先 `cd` 进 `dca-ledger`）再跑；或告诉我报错全文。

---

## 二、验收勾选

| # | 项 | 完成 |
|---|----|------|
| 1 | 有 `dca-ledger/csv_io.py`，内含 `ledger_path` | [ ] |
| 2 | `main.py` 用 `from csv_io import ledger_path`（或等价） | [ ] |
| 3 | `list` / `summary` / `add` / `find` 仍能跑（菜单或命令行任一） | [ ] |
| 4 | 关键函数有一句短注释 | [ ] |
| 5 | README 若路径说明仍对，可不改；不对就改一句 | [ ] |
| 6 | Commit（说明类似 refactor：拆出 csv_io） | [ ] |

---

## 三、今天不要做的

- 不要上 class / 包 / `__init__.py`（除非你已很熟）
- 不要为了拆而改业务逻辑（金额校验、坏行跳过规则保持原样）
- 不要一次拆成五六个文件

卡了把报错贴过来；优先自己改，我提示不代写整文件。
