# 第 34 天实操：阶段 A 收口文档

隔了一阵没关系，今天不学新语法。目标：让**别人（或两个月后的你）5 分钟能跑起来**，并勾选阶段 A 出口。

主战场：更新 `dca-ledger/README.md`（可顺带确认第 33 天的 `csv_io.py` 已写进目录说明）。

---

## 〇、先热一下（隔了约 10 天）

阶段 A 你已经有的：

- `dca-ledger`：菜单 + 命令行；`add/list/summary/find`；坏金额 / 缺文件不闪退  
- `ledger_path` 在 **`csv_io.py`**（第 33 天拆出）  
- 算法：1、20、217、242  
- Git：日常 `main`；Commit ≠ Push  

易混（错题本）：终端别贴 \`\`\`bash；`assert` 不在 main；main 还用 `os.` 就要 `import os`。

开始前：若换过电脑 → **先 Pull**。  
第 33 天若还没 Commit（`csv_io.py` / `main.py` / lesson33）→ **今天一起交也可以**。

---

## 一、README 要补成「5 分钟能跑」

在现有 README 上改/加，不必另起长文。建议结构：

### 1. 环境（别人机器上缺什么）

写清例如：

- 需要 Python 3  
- 本仓库用 `.venv`（没有就：`python3 -m venv .venv`，再按需 `pip install …`——若目前**没有第三方包**，写「标准库即可」）  
- 不要提交 `.venv`

### 2. 怎么跑（命令，不要 Markdown 花括号说明）

- 仓库根目录一种  
- 或 `cd dca-ledger` 再跑一种（第 33 天后**推荐进目录跑**，方便 `import csv_io`）  
- 菜单 + 命令行各给例子  

### 3. 样例输出（贴一小段真实输出）

例如 `list` 或 `summary` 跑完屏幕上长什么样（3～8 行即可）。

### 4. 常见报错（各一行原因 + 怎么办）

至少覆盖你踩过的：

| 现象 | 怎么办 |
|------|--------|
| 终端里是 `>>>` | 先退出交互再敲命令 |
| `ModuleNotFoundError: csv_io` | 先 `cd` 进 `dca-ledger` 再跑 |
| `NameError: os` | main 里用了 `os.` 就要 `import os` |
| 金额无效 | 输入数字；属正常提示 |

### 5. 目录结构（更新）

补上 `csv_io.py`：路径 / CSV 相关。

---

## 二、阶段 A 出口勾选（对照 roadmap）

| # | 出口项 | 完成 |
|---|--------|------|
| 1 | README 按上面能让「陌生人」跑通菜单或 `list` | [ ] |
| 2 | `.gitignore` 挡住 `.venv` / 真实账单（`data/private/`） | [ ] |
| 3 | 本机再跑一次：`list` + `summary` 成功 | [ ] |
| 4 | 目录说明含 `main.py` + `csv_io.py` + `data/` | [ ] |
| 5 | Commit + **Push**（含第 33 天未交的改动） | [ ] |

第 26 天 CSV↔JSON **仍可不挡**阶段 A 收口；有空再补。

---

## 三、口述（对话回 2 句即可）

1. 别人克隆后，第一步该干什么？  
2. `csv_io.py` 和 `main.py` 各管什么？

---

## 四、今天不要做的

- 不上阶段 B（Agent / requests 大练）——那是第 35 天可选  
- 不重写整份 ledger  
- 不把 `.cursor/skills` 整仓、竞赛文件夹一股脑塞进这次 Commit（另说）
