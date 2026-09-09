# 编程题 1：安全地转成整数
#
# 要求：
#   1. 用 input 读入一行文字
#   2. 尝试 int(...) 转成整数
#   3. 成功：打印「你输入的整数是：x」
#   4. 失败（ValueError）：打印「请输入整数」
#   不要让程序闪退
#
# 运行：python exercises/lesson12/ex01_safe_int.py
# 自测：先输入 60，再输入 abc

# TODO: 在下面写代码
try:
    num=int(input('请输入一个整数:'))
    print(f'你输入的整数是{num}')
except ValueError:
    print(f'请输入整数')

