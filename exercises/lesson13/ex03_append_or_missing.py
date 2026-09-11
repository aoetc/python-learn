# 编程题 3：追加一行；没有文件也不要闪退
#
# 要求：
#   1. 用 "a" 模式，往 exercises/lesson13/memo.txt 末尾追加一行「已打卡\n」
#      （没有这个文件时，"a" 一般会新建，这是正常的）
#   2. 然后再用 "r" 读 exercises/lesson13/names.txt
#      若你故意把路径写成一个不存在的文件名，要用 try/except FileNotFoundError
#      打印「文件不存在」（本练习：读 names.txt 即可，它存在）
#   3. 读成功就 print 读到的原文
#
# 提示：两个 with 可以分开写；追加用 "a"，读用 "r"。
#
# 运行：python exercises/lesson13/ex03_append_or_missing.py

# TODO: 在下面写代码
with open('exercises/lesson13/memo.txt','a') as f:
    f.write('已打卡\n')
with open('exercises/lesson13/memo.txt','r') as f:
    print(f.read())