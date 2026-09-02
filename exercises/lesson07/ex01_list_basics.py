# 编程题 1：list 基础
#
# 要求：
#   1. 创建一个 list：subjects = ["Python", "数学", "英语"]
#   2. 打印整个 list
#   3. 打印第一个科目、最后一个科目（用下标，最后一个可用 -1）
#   4. 打印 list 长度
#   5. append 追加 "算法"，再打印整个 list
#
# 运行：python exercises/lesson07/ex01_list_basics.py

# TODO: 在下面写代码

subjects=['Python','数学','英语']
print(subjects)
print(subjects[0])
print(subjects[-1])
s=len(subjects)
print(s)
subjects.append('算法')
print(subjects)
