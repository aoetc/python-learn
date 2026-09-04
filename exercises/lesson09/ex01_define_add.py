# 编程题 1：定义函数
#
# 要求：
#   1. 定义函数 add(a, b)，返回 a + b
#   2. 定义函数 is_pass(score)：score >= 60 返回 True，否则 False
#   3. 打印 add(3, 5) 和 is_pass(59)、is_pass(60)
#
# 运行：python exercises/lesson09/ex01_define_add.py

# TODO: 在下面写代码
def add(a,b): 
    return a+b
def is_pass(score):
    if score>=60:
        return True
    else:
        return False
print(add(3,5))
print(is_pass(59))
print(is_pass(60))