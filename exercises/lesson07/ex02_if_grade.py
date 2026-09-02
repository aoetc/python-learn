# 编程题 2：条件判断 — 及格线
#
# 要求：
#   1. 用 input 读入一个整数分数 score
#   2. 若 score >= 60，打印「及格」
#   3. 否则打印「不及格」
#   4. 再测试：输入 60 应该算及格
#
# 运行：python exercises/lesson07/ex02_if_grade.py

# TODO: 在下面写代码
score=int(input('请输入分数:'))
if score>=60:
    print('及格')
else:
    print('不及格')

