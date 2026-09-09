# 编程题 3（加分）：输错了再试
#
# 要求：
#   1. 循环请用户输入分数，转成 int
#   2. 成功则打印分数，并 break 离开循环
#   3. 失败则打印「请输入整数」，继续循环
#
# 提示：
#   while True:
#       try:
#           ...
#           break
#       except ValueError:
#           ...
#
# 运行：python exercises/lesson12/ex03_retry_score.py

# TODO: 在下面写代码
while True:
    try:
        a=int(float(input('请输入分数')))
        print(a)
        break
    except ValueError:
        print('请输入整数')