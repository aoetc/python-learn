# 编程题 4（加分）：elif 成绩等级
#
# 要求：
#   1. input 读入 score（整数）
#   2. 用 if / elif / else 打印等级：
#        score >= 90  → 优秀
#        score >= 80  → 良好
#        score >= 60  → 及格
#        否则         → 不及格
#   3. 注意 elif 顺序：从高到低判断
#
# 运行：python exercises/lesson07/ex04_grade_letter.py

# TODO: 在下面写代码

score=int(input('请输入分数:'))
if score>=90:
    print('优秀')
elif score>=80:
    print('良好')
elif score>=60:
    print('及格')
else:
    print('不及格')
