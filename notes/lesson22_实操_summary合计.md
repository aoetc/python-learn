# 第 22 天实操：summary 合计

今天加一个命令 **`summary`**（或你起名 `total` 也行）：

- 读 `data/ledger.csv`  
- 打印 **笔数**（有几条账）  
- 打印 **金额合计**  
- 遇到坏行：跳过或提示，**程序不闪退**  
- 文件不存在：友好提示（同 list）

不做按日期筛选、不删行（第 23 天）。

---

## 〇、人话小结

`list` 是把每一行念出来；`summary` 是边读边算：

```text
跳过第一行表头 date,money
每一行拆成：日期 , 金额
金额加起来；笔数 +1
最后 print 笔数和合计
```

拆一行可以用：

```python
parts = line.strip().split(",")
# parts[0] 日期，parts[1] 金额字符串
money = float(parts[1])
```

`float(...)` 失败（空行、乱写）→ 用 `try/except ValueError` 跳过这一行。

---

## 一、今天验收

运行后输入 `summary`：

1. 对你现在的两笔账，应看到类似：  
   - 笔数：2  
   - 合计：300.0（或 300）  
2. 没有文件时：提示先 add，不 Traceback  
3. （可选）在 csv 里故意加一行乱数据，summary 仍能跑完  

---

## 二、逐步做

### 步骤 1：写 `do_summary()`（和 do_add / do_list 平级）

路径公式继续复制第 20/21 天那两行。

推荐骨架（自己敲全）：

```text
count = 0
total = 0.0
try:
    打开 path 读行
    for line in lines:
        去掉空白；空行 continue
        若是表头（例如以 date 开头，或第一行）→ continue
        try:
            按逗号 split
            money = float(金额那段)
            total += money
            count += 1
        except ValueError:
            print("跳过坏行:", line)   # 或静默 continue
    print("笔数:", count)
    print("合计:", total)
except FileNotFoundError:
    print("还没有数据,请先add")
```

跳过表头的两种简单办法（选一种）：

- 第一行直接 `continue`（用一个 `first = True` 标记）  
- 或：`if line.startswith("date"): continue`

### 步骤 2：改菜单

- 打印里加上 `summary--合计`  
- `elif cmd == "summary": do_summary()`  
- 删掉「今只是骨架」这类过时句子（顺手改）

### 步骤 3：更新 README 一行

补上：输入 `summary` 可看笔数和合计。

### 步骤 4：自测后叫我

说「第 22 天做完了」。

---

## 三、今天不做

- 筛选某一天  
- 删除一行  
- `csv` 模块（想用可以，`split(",")` 够用）  
- 拆多文件  

---

## 四、常见坑

| 现象 | 原因 |
|------|------|
| 合计多了 / 报错 | 把表头 `date,money` 也 `float` 了 → 要跳过表头 |
| `float` 炸了 | 空行或坏行 → 内层 `try/except ValueError` |
| 路径又错 | 继续用 `__file__` 那套，和 list 相同 |

卡住贴 `do_summary` 或报错。
