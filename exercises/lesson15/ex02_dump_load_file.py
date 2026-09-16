# 编程题 2：JSON 写入文件再读回
#
# 要求：
#   1. import json
#   2. 字典 d = {"name": "李宏", "score": 90}
#   3. 用 with open(..., "w", encoding="utf-8") 打开
#      exercises/lesson15/demo.json
#      用 json.dump 把 d 写进去（可加 ensure_ascii=False）
#   4. 再用 "r" 打开同一个文件，json.load 读回来并 print
#
# 在仓库根目录运行：
#   python exercises/lesson15/ex02_dump_load_file.py

# TODO: 在下面写代码
import json
d = {"name": "李宏", "score": 90}
with open('exercises/lesson15/demo.json','w',encoding='utf-8') as f:
    json.dump(d,f)
with open('exercises/lesson15/demo.json','r',encoding='utf-8') as f:
    data=json.load(f)
print(data)
    