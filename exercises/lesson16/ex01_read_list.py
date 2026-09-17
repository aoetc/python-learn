# 编程题 1：读出 JSON 列表并打印
#
# 要求：
#   1. import json
#   2. 用 "r" 打开 exercises/lesson16/scores.json
#   3. json.load 得到 list
#   4. 用 for 循环打印每个人的 name 和 score
#      （格式自定，能看懂即可，例如：李宏 90）
#
# 在仓库根目录运行：
#   python exercises/lesson16/ex01_read_list.py

# TODO: 在下面写代码
import json
with open('exercises/lesson16/scores.json','r') as f:
    l=json.load(f)
    for i in l:
        print(i)