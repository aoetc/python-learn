# 第 11 天：模块 + venv / pip（实操为主）

函数后面接模块。今天**少刷概念题，多动手**。  
编程/命令全在下面；轻量选择判断在文末，做完可选。

教程：廖雪峰「使用模块」「安装第三方模块」。Anaconda **先不装**。

---

## 〇、人话小结（2 分钟）

- **模块** = 一个能被 `import` 的 `.py`（工具箱）
- **`import`** = 把工具箱拿到当前文件用
- **`if __name__ == "__main__"`** = 只有「直接运行这个文件」时才执行下面的测试代码
- **`venv`** = 给项目单独开一间装包的房间
- **`pip`** = 往房间里安装别人的库

自己的复杂逻辑 → 写成 `.py` 再 import。  
别人的库 → venv 里 pip install。两件事别混。

---

## 一、今天实操（按顺序做）

### 步骤 A：自己的模块（`exercises/lesson11/`）

| 文件 | 做什么 |
|------|--------|
| `greet_mod.py` | 写函数 `greet(name)`，返回欢迎语；底部用 `if __name__ == "__main__"` 自测 |
| `use_greet.py` | `import` 上面的模块，调用并打印；**不要**再写一遍 greet |

在项目根目录运行：

```text
python exercises/lesson11/greet_mod.py
python exercises/lesson11/use_greet.py
```

期望：直接跑 `greet_mod.py` 会看到自测打印；跑 `use_greet.py` 也能用到 `greet`，但**不会**误触发「只有主程序才该跑」的那部分（若你写对了 `if __name__`）。

### 步骤 B：venv + pip（在仓库根目录 `python-learn`）

PowerShell 里：

```text
python -m venv .venv
.\.venv\Scripts\Activate.ps1
python -m pip install -U pip
pip install requests
python -c "import requests; print(requests.__version__)"
deactivate
```

若激活报错（执行策略），把报错原文发我。

做完后：

- 项目里会出现 `.venv/`（很大，**不要**提交到 Git；应在 `.gitignore` 里）
- 你验证了：激活环境 → pip 装包 → `import` 能用

今天装 `requests` 只为练手，装完知道流程即可，后面用不用得到再说。

### 步骤 C（可选）：奇偶剪枝级的小观察

对比：不激活 venv 时，系统 Python 里未必有刚装的 `requests`。这就是 venv「隔离」的感觉。

---

## 二、轻量判断（可选，对/错）

**1.** 自己写的函数要复用，应写成 `.py` 再 `import`，不是封进 venv 里。

**2.** `if __name__ == "__main__"` 在文件被别人 import 时，下面的测试代码一般不会跑。

**3.** 换电脑（比如以后换 Mac）要把整个 `.venv` 文件夹拷过去才能用。

**4.** `pip` 负责装包，`venv` 负责隔离环境。

---

## 参考答案（做完再看）

<details>
<summary>判断</summary>

1. 对  2. 对  3. 错（应重建 venv 再 pip；可用 requirements.txt）  4. 对

</details>
