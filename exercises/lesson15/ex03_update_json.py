# 编程题 3（加分）：读出 → 改掉 → 写回
#
# 要求：
#   1. 先保证 exercises/lesson15/demo.json 存在
#      （可先成功跑一遍 ex02，或自己 dump 一份）
#   2. json.load 读出 demo.json
#   3. 把 score 改成 95（或其他整数）
#   4. 再用 json.dump 写回同一个文件
#   5. 再 load 一次并 print，确认改成功了
#
# 在仓库根目录运行：
#   python exercises/lesson15/ex03_update_json.py

# TODO: 在下面写代码
import json
with open('exercises/lesson15/demo.json','r',encoding='utf-8') as f:
    d=json.load(f)
    d["score"]=95
with open('exercises/lesson15/demo.json','w',encoding='utf-8') as f:
    json.dump(d,f)
with open('exercises/lesson15/demo.json','r',encoding='utf-8') as f:
    data=json.load(f)
print(data)