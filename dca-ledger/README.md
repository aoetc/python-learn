# dca-ledger

简单记账小工具（命令行）。

## 怎么运行

在仓库根目录：

```bash
.venv/bin/python dca-ledger/main.py
```

或先进入项目再跑：

```bash
cd ~/Developer/python-learn/dca-ledger
../.venv/bin/python main.py
```

出现菜单后输入命令即可。

## 怎么用

- `add`：输入日期、金额 → 追加写入 `data/ledger.csv`
- `list`：打印全部流水
- `summary`：打印笔数和金额合计

## 注意

- 不要提交 `.venv`
- 不要提交真实账单；`data/ledger.csv` 样例可以交

**不要**在已经出现 `>>>` 的 Python 交互界面里贴上面的命令；先 `exit()` 或 Ctrl+D 退出，再在普通终端里运行。
