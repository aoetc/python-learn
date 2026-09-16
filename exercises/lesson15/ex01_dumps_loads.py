# 编程题 1：dict ↔ JSON 字符串
#
# 要求：
#   1. import json
#   2. 有一个字典：{"name": "李宏", "score": 90}
#   3. 用 json.dumps 变成字符串，print 这个字符串，再 print 它的 type
#   4. 用 json.loads 变回字典，print 字典里的 name
#
# 在仓库根目录运行：
#   python exercises/lesson15/ex01_dumps_loads.py

# TODO: 在下面写代码
import json
a={"name": "李宏", "score": 90}
b=json.dumps(a)
print(b)
print(type(b))
c=json.loads(b)
print(c['name'])