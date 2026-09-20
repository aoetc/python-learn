# 编程题 2：JSON → CSV
#
# 要求：
#   1. 先保证 out.json 存在（可先跑通 ex01）
#   2. json.load 读出 list
#   3. 写 out.csv：第一行 date,money，后面每行一条
#   4. print 提示
#
# 运行（仓库根目录）：
#   python exercises/lesson26/ex02_json_to_csv.py

# TODO: 在下面写代码
import json

try:
    # 1. 只读 JSON
    with open("exercises/lesson26/out.json", "r", encoding="utf-8") as f:
        rows = json.load(f)

    # 2. 另开 CSV 来写（不要用上面那个 f）
    with open("exercises/lesson26/out.csv", "w", encoding="utf-8") as f:
        f.write("date,money\n")
        for i in rows:
            f.write(f'{i["date"]},{i["money"]}\n')

    print("已写入 out.csv")
except FileNotFoundError:
    print("out.json不存在，请先跑 ex01")
