# 第 35 天 · 缓冲：requests 打一个公开 JSON 接口

对应 roadmap：`d35`，90 分钟。阶段 A 的收尾动作，进 B 之前最后一次"手动"练习。

## 目标

写一个脚本，用一个公开 JSON 接口取数据，打印其中 2–3 个字段；网络出问题时不能崩，要给出人能看懂的错误并返回非 0 退出码。

## 交付物

```
d35/
└── d35_json.py      ← 你写，只有这一个文件
```

## 接口契约（测试按这个判，不许改）

```python
def get_json(url: str, timeout: float = 5.0) -> dict:
    """GET url，返回解析后的 dict。
    非 200、JSON 解析失败、网络异常 → 一律抛 RuntimeError。"""

def main(argv: list[str] | None = None) -> int:
    """成功：打印 2–3 个字段，返回 0。
    失败：stderr 打印一行错误说明，stdout 不输出，返回 1。"""
```

`if __name__ == "__main__":` 里用 `sys.exit(main())`。

## 硬性要求

1. 用 `import requests`，调用时写 `requests.get(...)`（测试会替换这个方法）。
2. **必须传 `timeout`**，且 `get_json` 的默认值是 5.0。
3. 不要在代码里写任何 API Key；不要 `print(整个响应)`。
4. 打印格式不限，但每个字段单独一行，形如 `name: xxx` 或 `name=xxx`，至少 2 行。
5. 允许失败时用 `sys.stderr`，不要吞掉异常。

## 跑测试

在仓库根目录：

```bash
python3 -m pytest study/d35 -q     # 若没装：python3 -m pip install pytest
```

## 验收标准（7 条全绿才算过）

| # | 测什么 |
|---|---|
| 1 | 正常返回时，`get_json` 返回 dict |
| 2 | `status_code != 200` → `RuntimeError` |
| 3 | 返回体不是合法 JSON → `RuntimeError` |
| 4 | `requests` 超时 → `RuntimeError` |
| 5 | `get_json` 把 `timeout` 传给了 `requests.get` |
| 6 | `main()` 成功时返回 0，且 stdout 至少 2 行 |
| 7 | `main()` 失败时返回 1，stderr 非空 |

## 不许做的事

- 不许用 try/except 把异常吞掉后 `return 0`。
- 不许为了过测试改 `test_d35_json.py`。
- 不许复制网上的成品：这段代码两周后你要在面试里讲。

## 卡住时

先自己读 traceback，把最后三行发我，并说"你觉得是哪一行的问题"。不要直接要答案。
