# 编程题 3：list 求平均分
#
# 要求：
#   1. scores = [90, 85, 88]  （先写死在代码里，不用 input）
#   2. 用 sum() 和 len() 算平均分，存到 average
#   3. 用 f-string 打印：三科平均分为 xx.x
#      提示：保留 1 位小数可用 round(average, 1)
#   4. 若 average >= 60 打印「总体及格」，否则「总体不及格」
#
# 运行：python exercises/lesson07/ex03_score_average.py

# TODO: 在下面写代码

scores = [90, 85, 88]
average=sum(scores)/len(scores)
print(f'三科平均分为{average:.1f}')
if average>=60:
    print('总体及格')
else:
    print('总体不及格')