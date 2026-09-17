# 第 19 天实操：dca-ledger 立项骨架

今天**不新开廖雪峰大章**，也不写 CSV 读写。  
只做一件事：把小项目的「空壳」立起来，能跑、能说明白以后干什么。

项目目录（放在本仓库里，双机好同步）：

```text
python-learn/
  dca-ledger/
    README.md      ← 别人怎么用（今天先写骨架）
    main.py        ← 入口：今天只打印用法
    .gitignore     ← 已备好，不用改
```

---

## 〇、这个项目是干什么的（人话）

**dca-ledger** = 一个极简「流水账」命令行小工具。

以后（第 20 天起）大概能：

- `add`：记一笔（日期 + 金额）→ 存进 CSV 文件  
- `list`：把记过的列出来  
- 再往后：合计、筛选……

**CSV** 先记住一句：普通文本，一行一条，中间用逗号分隔。今天**不用写**它。

今天验收就一条：

```bash
cd dca-ledger
python main.py
```

屏幕上打印出用法说明（提到以后会有 add / list），**不报错**。

---

## 一、今天逐步做（按顺序打勾）

### 步骤 1：确认文件夹

仓库里应有 `dca-ledger/`（若没有，自己新建同名文件夹）。  
里面已有 `.gitignore`（忽略 `.venv`、`__pycache__` 等）。

### 步骤 2：写 `main.py`（你自己敲）

要求：

1. 用 `print` 打印几行用法，至少包含：  
   - 这是 dca-ledger  
   - 以后可用：`add`（记账）、`list`（查看）  
   - 今天尚未实现，仅脚手架  
2. 建议写成：

```python
def main():
    print("...")
    # 多几行说明

if __name__ == "__main__":
    main()
```

（`if __name__ == "__main__"` 第 11 天练过：直接运行本文件才进 `main`。）

**不要**今天就写 `open`、CSV、`add` 逻辑。

### 步骤 3：跑通

在仓库根目录或 `dca-ledger` 里都能跑，例如：

```bash
cd ~/Developer/python-learn/dca-ledger
../.venv/bin/python main.py
```

或（若已激活 venv / 系统 python 可用）：

```bash
python main.py
```

看到你的用法说明即可。

### 步骤 4：写 `README.md`（你自己敲，可短）

至少写清这些小标题（中文即可）：

1. **项目是什么**（一两句）  
2. **怎么运行**（复制你验证过的命令）  
3. **计划功能**（add / list；注明「尚未实现」）  
4. **注意**：不要提交 `.venv`；不要提交真实账单  

不要抄成长文。半屏以内够用。

### 步骤 5：自检清单

- [ ] `python main.py` 能跑、有打印  
- [ ] README 里有「怎么运行」  
- [ ] 没有去实现 add/list 写文件  
- [ ] Changes 里没有 `.venv`

### 步骤 6：收工

告诉我「第 19 天做完了」，我帮你看 `main.py` + README。  
通过后：**Commit + Push**（可交：`dca-ledger/`、本实操笔记、进度；不要交 `.venv`）。

---

## 二、今天明确不做

- 不写 CSV  
- 不装一堆新库  
- 不新建第二个 GitHub 仓库（就放在 `python-learn/dca-ledger/`）  
- 不追完善「完美架构」

---

## 三、和后面几天的关系

| 天 | 你加什么 |
|----|----------|
| 19（今天） | 空壳 + 说明 |
| 20 | `add` 写一行到 CSV |
| 21 | `list` 读出来 + README 写清三步 |

一天一小步。今天只把壳立住就赢了。
