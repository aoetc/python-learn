# 第 30 天实操：阶段 A 中检

今天**不学新章**。目标：假装自己是「第一次打开这个项目的人」，按 README 把 `dca-ledger` 跑通，卡点记下来并修好。

编程目录仍是 `dca-ledger/`（没有新的 `exercises/lesson30`）。

---

## 〇、中检是什么（人话）

前面很多天各写了一块：add、list、summary、find、坏金额、命令行、`assert`……  
中检 = **整包验收**：别人（或未来的你）只看 README，能不能一次跑通。

卡了不等于失败：记下「卡在哪 → 怎么修」，修完再勾选。

---

## 一、开始前

1. 若刚换电脑 / 隔了很久：先 **Pull**。  
2. 打开 `dca-ledger/README.md`，下面清单按它来。  
3. 终端用**普通 shell**，不要出现 `>>>`（有的话先 `exit()`）。

---

## 二、验收勾选（你自己打勾）

### A. 菜单方式（README 第 24 天五条）

在仓库根目录：

```bash
.venv/bin/python dca-ledger/main.py
```

| # | 要看到什么 | 完成 |
|---|------------|------|
| 1 | 出现菜单；`add` → 日期+金额 →「已保存」；`data/ledger.csv` 多一行 | [ ] |
| 2 | `list` 能打印账本内容 | [ ] |
| 3 | `summary` 有笔数和总额（合理即可） | [ ] |
| 4 | `find` 能按日期找出记录（或提示没有） | [ ] |
| 5 | `add` 金额输 `abc` →「金额无效」类提示，**不闪退、不写入** | [ ] |

### B. 命令行方式（第 28 天）

```bash
.venv/bin/python dca-ledger/main.py list
.venv/bin/python dca-ledger/main.py summary
.venv/bin/python dca-ledger/main.py add 2026-10-09 50
.venv/bin/python dca-ledger/main.py find 2026-10-09
```

| # | 要看到什么 | 完成 |
|---|------------|------|
| 6 | 上面四条**不必进菜单**也能跑 | [ ] |
| 7 | 不带参数再跑一次：还能进菜单 | [ ] |

### C. 文档与仓库

| # | 要看到什么 | 完成 |
|---|------------|------|
| 8 | README 里「怎么运行 / 命令行用法」和真实操作一致 | [ ] |
| 9 | 中检通过后：**Commit + Push**；GitHub 网页能看到最新 README | [ ] |

### D. 口述（任选 2 句，对话里回我）

1. `ledger_path()` 为什么比到处写 `"data/ledger.csv"` 更好？  
2. 用户输坏金额用 `try/except`，第 29 天的 `assert` 是干啥的？  
3. `sys.argv[1]` 大概是什么？

---

## 三、常见卡点（先自己对一下）

| 现象 | 可能原因 |
|------|----------|
| `No such file` / 找不到 venv | 不在仓库根目录；或还没建 `.venv` |
| 菜单有了但 CSV 没变 | 路径看错文件；或 add 金额无效提前 return 了 |
| 命令行没反应、一直要 input | `sys.argv` 分支没走到；参数个数不够 |
| 终端里是 `>>>` | 进了 Python 交互环境，先退出 |

卡死了：把**完整报错**或「你敲了什么、屏幕显示什么」贴到对话。

---

## 四、中检结果（做完填）

- 通过项：___ / 9  
- 卡点与修复（一两句）：  
- 是否已 Push：是 / 否  

填完跟我说「finished」，我再更新 `notes/学习进度.md`。

---

## 附：暂不挡中检

第 26 天 CSV↔JSON 仍可回头收；今天不强制。  
第 29 天 `exercises/lesson29/` 已过即可，不必塞进 ledger。
