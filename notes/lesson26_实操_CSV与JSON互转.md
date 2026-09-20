# 第 26 天实操：CSV ↔ JSON 互转

今天**不新开大章**。把你会的两样拼起来：

- CSV：一行一条，逗号分隔（ledger 那种）  
- JSON：常常是「字典的列表」

练习目录：`exercises/lesson26/`

---

## 〇、人话小结

**CSV → JSON：**  
读出每一行 → 变成一个 dict → 放进 list → `json.dump` 写成 `.json`

**JSON → CSV：**  
`json.load` 得到 list → 写出表头 → 每一行 `日期,金额`

例子：

CSV：

```text
date,money
2026-09-17,100.0
2026-09-15,200.0
```

对应 JSON：

```json
[
  {"date": "2026-09-17", "money": 100.0},
  {"date": "2026-09-15", "money": 200.0}
]
```

---

## 一、今天验收

在仓库根目录运行：

```bash
.venv/bin/python exercises/lesson26/ex01_csv_to_json.py
.venv/bin/python exercises/lesson26/ex02_json_to_csv.py
```

1. ex01：读 `sample.csv` → 写出 `out.json`，打开能看到 list of dict  
2. ex02：读 `out.json`（或自备 json）→ 写出 `out.csv`，打开能看到表头+数据行  

路径建议继续用 `__file__` 旁目录，避免 Run 目录不对。

---

## 二、逐步做

### ex01：CSV → JSON

1. 算出目录：`base = dirname(abspath(__file__))`  
2. 读 `sample.csv`（跳过表头）  
3. 每行 `split(",")` → `{"date": ..., "money": float(...)}`  
4. `json.dump(列表, f, ensure_ascii=False, indent=2)` 写到 `out.json`  
5. `print` 一下列表或提示已保存  

坏行可以跳过（和 summary 一样）。

### ex02：JSON → CSV

1. `json.load` 读 `out.json`  
2. 用 `"w"` 写 `out.csv`：先写 `date,money\n`  
3. 对每个 dict：`f.write(f'{d["date"]},{d["money"]}\n')`  
4. print 提示  

若还没有 `out.json`，先成功跑完 ex01。

### 文件缺失

`try/except FileNotFoundError` 提示即可。

---

## 三、今天不做

- 改 dca-ledger 主菜单（练习放在 `exercises/lesson26/` 即可）  
- pandas  
- 第 27 天的目录大搬家  

---

## 四、做完

说「第 26 天做完了」。我看两个脚本和生成的文件。通过后 Commit + Push。
