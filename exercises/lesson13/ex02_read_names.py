# 编程题 2：读现成名单
#
# 同目录已经有 names.txt（三行名字）。不要改那个文件。
#
# 要求：
#   1. 用 with open("exercises/lesson13/names.txt", "r", encoding="utf-8") 打开
#   2. 用 readlines() 得到 list
#   3. 用 for 逐行 print（行末自带的 \n 会空一行，可先 .strip() 再打印）
#   4. 再 print 一共多少行（len）
#
# 运行：python exercises/lesson13/ex02_read_names.py

# TODO: 在下面写代码
with open("exercises/lesson13/names.txt", "r", encoding="utf-8") as f:
    lines=f.readlines()
    for line in lines:
        print(line.strip())
    print(len(lines))