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

## 目录结构

- `main.py`：菜单和 add / list / summary / find（路径用 `ledger_path()`）
- `data/ledger.csv`：样例账本（可提交）
- `data/private/`：真实账单放这里（不要提交；在项目 `.gitignore` 里已忽略）

## 怎么用

菜单方式：运行后按提示输入 `add` / `list` / `summary` / `find`。

命令行方式（少问答，在仓库根目录）：

```bash
.venv/bin/python dca-ledger/main.py list
.venv/bin/python dca-ledger/main.py summary
.venv/bin/python dca-ledger/main.py add 2026-09-22 80
.venv/bin/python dca-ledger/main.py find 2026-09-22
```

- `add`：后面跟日期、金额  
- `find`：后面跟日期  
- 不带参数时仍走原来的菜单  

## 注意

- 不要提交 `.venv`
- 不要提交真实账单；`data/ledger.csv` 样例可以交
- 不要在已经出现 `>>>` 的 Python 交互界面里贴上面的命令；先 `exit()` 或 Ctrl+D 退出，再在普通终端里运行。

## 验收清单（第 24 天）

1. 能 add ：运行main.py,输入add，再输入时间金额，看到已保存就是完成，完成后data/ledger.csv多出填写的数据。
2. 能 list:运行main.py,输入list，会自动输入完data/ledger.csv的所有数据
3. 文件缺失怎么办：写了try，except代码，文件缺失也不会打断程序运行
4. 非数字金额怎么办：add 时金额输入非数字（如 abc），提示「金额无效」，不写入文件、不闪退。
5. 别人怎么安装运行：已安装 Python 3；打开 `python-learn`，运行 `.venv/bin/python dca-ledger/main.py`，看到菜单即可。

