# dca-ledger

简单记账小工具（命令行）。

## 环境

- 需要 **Python 3**
- 本仓库用 `.venv`（虚拟环境）；当前只用标准库，**不必**再 `pip install` 一堆包
- 若还没有 `.venv`：在仓库根目录执行 `python3 -m venv .venv`
- 不要提交 `.venv`

## 怎么运行（推荐）

拆出 `csv_io.py` 之后，**建议先进入项目目录再跑**（这样一定能找到模块）：

```bash
cd ~/Developer/python-learn/dca-ledger
../.venv/bin/python main.py
```

出现菜单后输入 `add` / `list` / `summary` / `find`。

也可在仓库根目录：

```bash
.venv/bin/python dca-ledger/main.py
```

（若报找不到 `csv_io`，改用上面「先 cd 再跑」。）

## 目录结构

- `main.py`：菜单、命令行、`add` / `list` / `summary` / `find`
- `csv_io.py`：账本路径 `ledger_path()`（相对本文件找 `data/ledger.csv`）
- `data/ledger.csv`：样例账本（可提交）
- `data/private/`：真实账单放这里（不要提交；已在 `.gitignore`）

## 怎么用

### 菜单

运行后按提示输入命令。

### 命令行（少问答）

在 `dca-ledger` 目录下：

```bash
../.venv/bin/python main.py list
../.venv/bin/python main.py summary
../.venv/bin/python main.py add 2026-09-22 80
../.venv/bin/python main.py find 2026-09-22
```

在仓库根目录也可以：

```bash
.venv/bin/python dca-ledger/main.py list
```

- `add`：后面跟日期、金额  
- `find`：后面跟日期  
- 不带参数时仍走菜单  

## 样例输出

`list` 大致像：

```text
date,money
2026-09-17,100.0
2026-09-15,200.0
2026-09-20,50.0
2026-09-22,80.0
```

`summary` 大致像：

```text
笔数: 4
总额 430.0
```

（你本机数据行数可能不同，能打印出笔数和总额即可。）

## 常见报错

| 现象 | 怎么办 |
|------|--------|
| 提示符是 `>>>` | 进了 Python 交互界面；先 `exit()` 或 Ctrl+D，再在普通终端敲命令 |
| `ModuleNotFoundError: csv_io` | 先 `cd` 进 `dca-ledger`，再用 `../.venv/bin/python main.py …` |
| `NameError: name 'os' is not defined` | `main.py` 里用了 `os.`，顶部要有 `import os` |
| 提示金额无效 | 金额请输入数字；不会写入文件（正常保护） |
| 还没有数据 / 文件找不到 | 先 `add` 一笔；程序应提示而不是整段闪退 |

## 注意

- 不要提交 `.venv`
- 不要提交真实账单；`data/ledger.csv` 样例可以交

## 验收清单（阶段 A）

1. 能 `add`：日期 + 金额 →「已保存」，CSV 多一行  
2. 能 `list` / `summary` / `find`  
3. 文件缺失、非数字金额：有提示，不闪退  
4. 别人按本文「环境 + 怎么运行」能跑通菜单或 `list`  
