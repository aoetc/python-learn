# 编程题 1：把「及格判断」改成函数
#
# 要求：
#   1. 定义 letter_grade(score)
#      score >= 60 返回字符串「及格」，否则返回「不及格」
#   2. 打印：
#        letter_grade(59)
#        letter_grade(60)
#        letter_grade(90)
#   3. 不要再用 input（这次用函数，方便反复测）
#
# 运行：python exercises/lesson10/ex01_grade_fn.py

# TODO: 在下面写代码
def letter_grade(score):
    if score>=60:
        return f'及格'
    else:
         return f'不及格'
print(letter_grade(59))
print(letter_grade(60))
print(letter_grade(90))