# study/ 怎么用

这是教练系统，配合 `notes/` 里的 roadmap 使用。三个文件分工：

| 文件 | 谁写 | 作用 |
|---|---|---|
| `AGENTS.md` | 已写好 | 教练协议：AI 按它出题、判分、讲评 |
| `progress.md` | 每天更新 | 单一事实源：学到哪、过了没、卡在哪 |
| `mistakes.md` | 每错一次加一行 | 错题本：按错误类型归类 |
| `AUDIT.md` | 一次性 | 2026-11-09 的状态对账，看清欠了哪几天 |

## 装进仓库（一次性）

```bash
cp -R ~/Documents/deepseek-harness/default-workspace/study ~/Developer/python-learn/
cd ~/Developer/python-learn
git add study && git commit -m "study: 加入教练系统（协议/进度/错题/d35）" && git push
```

## 每天怎么跑

1. 打开 `study/progress.md`，看今天该做第几天。
2. 建当天文件：`study/dNN/dNN_主题.py`，自己写，别让 AI 写。
3. 跑测试：`python3 -m pytest study/dNN -q`
4. 红了 → 把 traceback 最后三行贴给 AI，并说"你觉得是哪一行"。
5. 绿了 → 让它讲评：对的、bug、可读性、更地道的写法。
6. 收尾：改 `progress.md`、记 `mistakes.md`、commit + push。

## 环境

仓库自带的 `.venv` 里有 requests，但没有 pytest：

```bash
cd ~/Developer/python-learn
.venv/bin/python -m pip install pytest
.venv/bin/python -m pytest study/d35 -q
```

## 现在从哪开始

第 35 天（`d35/`）的题已经就绪。先花 30 分钟**验收** 15/16/26 那三次作业（代码已经写了，只是没打勾没跑过），再走 d35——见 `AUDIT.md` 第二节。
