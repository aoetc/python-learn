# python-learn

杭州软件工程大二学生的 Python 学习仓库。  
目标方向：**Agent 应用开发工程师**（2029 届毕业，最晚 2027 暑假开始实习）。

这不是课程作业合集，而是按天记录「自己写过、能跑、能讲清楚」的练习。

---

## 我在学什么

| 阶段 | 时间 | 目标 |
|------|------|------|
| A | 2026.9–11 | Python 基础 + Git 每日提交 + 简单算法 |
| B | 2026.12–2027.3 | 最小 Agent 闭环（API、工具调用、RAG） |
| C | 2027.3 起 | 投递杭州 Agent 实习 |

**主教程：** [廖雪峰 Python 教程](https://www.liaoxuefeng.com/wiki/1016959663602400)  
**编辑器：** Cursor（生成代码后自己读 diff 再提交）  
**版本管理：** GitHub Desktop

---

## 仓库结构（会逐步补齐）

```text
python-learn/
├── README.md          # 本文件：项目说明
├── hello.py           # 第一个程序（待创建）
├── notes/             # 按章节整理的练习脚本
├── algo/              # 力扣简单题（数组、哈希、栈、二分）
└── data/              # 本地样例数据（不放真实隐私）
```

阶段 A 结束后，会另建 `dca-ledger` 仓库做 CLI 小项目（定投 CSV 统计）。

---

## 环境要求

- **Python 3.12+**（安装时勾选 `Add python.exe to PATH`）
- **GitHub Desktop**（Commit / Push）
- **Cursor** 或任意编辑器

检查 Python 是否装好：

```powershell
python --version
```

---

## 每天怎么学（固定流程）

1. 看廖雪峰当天指定章节，**例题自己敲**，不要只复制。
2. 在 Cursor 里保存到对应 `.py` 文件。
3. 终端运行，确认无报错：

   ```powershell
   python hello.py
   ```

4. 打开 GitHub Desktop：
   - 左侧看到文件变化
   - **Summary** 用中文写做了什么（例如：`Add hello.py`）
   - 点 **Commit to main**
   - 点 **Push origin** 同步到 GitHub 网站

---

## 廖雪峰第一遍路线（跳过后面再补）

**必看：** 安装 → 第一个程序 → 基础（变量、list/dict、循环、函数）→ 模块与 pip → 错误处理 → 文件 IO → 类与实例 → JSON  

**先跳过：** 函数式编程、元类、进程线程、GUI、邮件、Web、异步 IO

---

## 算法（每周 3–4 题，从第 2 周起）

平台：[LeetCode 力扣](https://leetcode.cn/)  

起步题型：两数之和、有效括号、二分查找。  
代码放在 `algo/` 文件夹，文件名例如 `001_two_sum.py`。

---

## 进度记录

- [x] 2026-09-01 创建仓库，完成 Initial commit
- [ ] 添加 README 并 Push
- [ ] 安装 Python，运行 `hello.py`
- [ ] 完成廖雪峰「安装 Python + 第一个程序」
- [ ] 累计 12 道简单算法题

（每完成一项就在本地改 README 勾选，再 Commit 一次。）

---

## 注意事项

- **不要**把 `.venv/`、密码、API Key、真实身份证号提交上来（已在 `.gitignore` 里忽略常见项）。
- **不要**为求快而整段粘贴 AI 代码不读；面试要能解释每一行在干什么。
- 本仓库现阶段**只做 Python 基础**；LangChain / Agent 框架等阶段 B 再开新仓库或新目录。

---

## 关于我

- 学校：软件工程，杭州
- 此前：大一只浅尝 C
- 兴趣：理财（CAPE、VIX 等），后续可能做投研类 Agent 练手，但求职主线仍是 Agent 工程

有问题或想对照三年规划，见 Cursor 里的 [杭州 Agent 三年规划 Canvas](file:///C:/Users/aoetc/.cursor/projects/empty-window/canvases/hangzhou-agent-roadmap.canvas.tsx)。
