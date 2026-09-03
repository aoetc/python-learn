# 编程题 4（加分）：for 遍历 dict
#
# 要求：
#   1. grade = {"李宏": 90, "王五": 85, "赵六": 72}
#   2. 用 for name, score in grade.items():
#      每一行打印：李宏 90 分
#      （name 和 score 会依次变成每一对键和值）
#   3. 再用 for 循环数一数：分数 >= 80 的有几人，最后打印这个人数
#
# 运行：python exercises/lesson08/ex04_for_dict.py

# TODO: 在下面写代码
grade = {"李宏": 90, "王五": 85, "赵六": 72}
for name,score in grade.items():
    print(f'{name}{score}分')
num=0
for score in grade.values():
    if score>=80:
        num+=1
print(num)