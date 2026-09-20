# 编程题 1：CSV → JSON
#
# 要求：
#   1. 读 exercises/lesson26/sample.csv（同目录也可用 __file__ 定位）
#   2. 跳过表头，每行变成 {"date": "...", "money": 数字}
#   3. 得到一个 list，json.dump 写到同目录 out.json
#      （建议 ensure_ascii=False, indent=2）
#   4. print 提示或 print 这个 list
#
# 运行（仓库根目录）：
#   python exercises/lesson26/ex01_csv_to_json.py

# TODO: 在下面写代码
# 注意：
#   - import json   ← 不要写成 import json:
#   - rows 用 list：rows = [] ，不要用 set()
#   - 加进去的是字典：{"date": datei, "money": moneyi}
#     不要写成 {"date:datei,money:moneyi"} 这种一整串字

import json

rows = []
with open("exercises/lesson26/sample.csv", "r", encoding="utf-8") as f:
    lines = f.readlines()

first = True
for line in lines:          # 必须有这一行：逐行处理
    if first:               # 第一行是表头，跳过
        first = False
        continue
    line = line.strip()
    if line == "":
        continue
    parts = line.split(",")
    datei = parts[0]
    moneyi = float(parts[1])
    rows.append({"date": datei, "money": moneyi})

with open("exercises/lesson26/out.json", "w", encoding="utf-8") as f:
    json.dump(rows, f, ensure_ascii=False, indent=2)

print(rows)
print("已写入 out.json")
