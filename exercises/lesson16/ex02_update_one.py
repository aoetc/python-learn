# 编程题 2：改一条再写回
#
# 要求：
#   1. load 读出 exercises/lesson16/scores.json（是一个 list）
#   2. 找到 name 为「李宏」的那一条，把 score 改成 95
#      （可用 for；或若你确定是第一条，也可用 rows[0]）
#   3. dump 写回同一个文件（建议 ensure_ascii=False）
#   4. 再 load 一次并 print，确认李宏是 95
#
# 注意：先 "r" 读，改完再 "w" 写；不要一上来就 "w"。
#
# 在仓库根目录运行：
#   python exercises/lesson16/ex02_update_one.py

# TODO: 在下面写代码
import json
with open('exercises/lesson16/scores.json','r') as f:
    l=json.load(f)
    for i in l:
        if i['name']=='李宏':
            i['score']=95
        else:
            continue
with open('exercises/lesson16/scores.json','w') as f:
    json.dump(l,f,ensure_ascii=False)
with open('exercises/lesson16/scores.json','r') as f:
    l2=json.load(f)
    for i in l2:
        if i['name']=='李宏':
            print(i)
        else:
            continue
