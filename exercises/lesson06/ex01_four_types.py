# 编程题 1：认识四种类型
#
# 要求：
#   1. 定义四个变量：age(int)、height(float)、name(str)、is_student(bool)
#   2. 用 f-string 打印一行：姓名、年龄、身高、是否学生
#   3. 分别 print(type(变量)) 四次，看清四种类型
#
# 运行：python exercises/lesson06/ex01_four_types.py

# TODO: 在下面写代码



age=int(input('年龄：'))
height=float(input('身高：'))
name=(input('姓名：'))
is_student=(input('是否学生：'))=='是'
print(f'姓名：{name},年龄:{age},身高:{height},是否学生:{is_student}')
print(type(age))
print(type(height))
print(type(name))
print(type(is_student))
