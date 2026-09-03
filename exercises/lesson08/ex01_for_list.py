# 编程题 1：for 遍历 list
#
# 要求：
#   1. subjects = ["Python", "数学", "英语"]
#   2. 用 for 循环，每一行打印一个科目
#   3. 循环结束后，再打印：一共 N 门课
#      N 用 len(subjects)
#
# 运行：python exercises/lesson08/ex01_for_list.py

# TODO: 在下面写代码
subjects = ["Python", "数学", "英语"]
for subject in subjects:
    print(subject)
print(f'一共{len(subjects)}课')