# 第 27 天实操：整理 `data/` 布局

今天**几乎不写新功能**。把 dca-ledger 的「文件放哪、文档怎么写」整理清楚。

（第 26 天 CSV↔JSON 若还没收工，可以先搁着，做完 27 再回去勾。）

---

## 〇、你已经有的（不用重做）

当前大概是：

```text
dca-ledger/
  main.py          ← 已有 ledger_path()，路径算一次
  README.md
  .gitignore       ← data/private/ 不提交
  data/
    .gitkeep
    ledger.csv     ← 样例流水（可提交）
```

第 27 天要做的是：**确认结构对、README 写清、自己跑一遍还通**。

---

## 一、今天验收

1. README 里有一小节 **「目录结构」**，写明代码和数据各在哪  
2. README 写清：样例用 `data/ledger.csv`；真实账单放 `data/private/`（不提交）  
3. 从仓库根目录跑一遍：`add` / `list` / `summary` / `find` 仍正常  
4. Changes 里没有 `.venv`、没有真实隐私账单  

---

## 二、逐步做

### 步骤 1：看一眼文件夹

打开 `dca-ledger/`，确认 `data/ledger.csv` 在。  
若误把 csv 放到别处，移回 `data/`，并确认 `main.py` 里都走 `ledger_path()`（不要再手写一串不同路径）。

### 步骤 2：改 README（你自己写）

在 `dca-ledger/README.md` 里加一节，例如：

```markdown
## 目录结构

- `main.py`：菜单和 add/list/summary/find
- `data/ledger.csv`：样例账本（可提交）
- `data/private/`：真实账单（不要提交，见 .gitignore）
```

可再补一句：路径由 `ledger_path()` 计算，相对 `main.py` 所在目录，从仓库根目录 Run 也对。

### 步骤 3：自测

```bash
cd ~/Developer/python-learn
.venv/bin/python dca-ledger/main.py
```

分别试 `list`、`summary`（可选再 `find`）。能跑即可。

### 步骤 4：清理注释（可选）

`main.py` 顶部若还写着「第 24 天 TODO」，可改成简短说明：数据在 `data/`，路径见 `ledger_path()`。

---

## 三、今天不做

- `sys.argv`（第 28 天）  
- 拆成多个 .py（第 33 天）  
- 不必重写 add/list 逻辑  

---

## 四、做完

说「第 27 天做完了」。我主要看 README 目录说明是否清楚、结构是否一致。  
通过后 Commit + Push（样例 csv 可交；`data/private/` 不要交）。
