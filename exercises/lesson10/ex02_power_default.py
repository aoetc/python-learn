# 编程题 2：默认参数
#
# 要求：
#   1. 定义 power(x, n=2)，返回 x 的 n 次方（x ** n）
#   2. 打印：
#        power(5)      应是 25（默认平方）
#        power(5, 3)   应是 125
#        power(2, 10)  应是 1024
#
# 运行：python exercises/lesson10/ex02_power_default.py

# TODO: 在下面写代码
def power(x, n=2):
    result=1
    while n>=1:
            result*=x
            n=n-1
    return result
print(f'power(5)应该是{power(5)}')
print(f'power(5,3)应该是{power(5,3)}')
print(f'power(2,10)应该是{power(2,10)}')