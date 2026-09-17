# 编程题 3（加分）：末尾加一条
#
# 要求：
#   1. load 读出 exercises/lesson16/scores.json
#   2. 往 list 里 append 一条新字典，例如：
#        {"name": "钱七", "score": 88}
#   3. dump 写回
#   4. 再 load 并 print，能看到新的一条
#
# 若 scores.json 被改乱了：可先手动把内容恢复成三个人，
# 或问我要一份初始内容。
#
# 在仓库根目录运行：
#   python exercises/lesson16/ex03_append_one.py

# TODO: 在下面写代码
import json
with open('exercises/lesson16/scores.json','r') as f:
    l=json.load(f)
    l.append({"name":"钱七","score":88})
with open('exercises/lesson16/scores.json','w') as f:
    json.dump(l,f,ensure_ascii=False)
with open('exercises/lesson16/scores.json','r') as f:
    data=json.load(f)
    print(data)