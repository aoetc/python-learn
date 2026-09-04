# 编程题 3：可变参数 — 乘积（廖雪峰练习）
#
# 要求：
#   改造 mul，使它可以接收一个或多个数，返回乘积。
#   mul(5) == 5
#   mul(5, 6) == 30
#   mul() 应报错 TypeError（至少一个参数）
#
# 提示：def mul(x, *args): ...
#
# 运行：python exercises/lesson09/ex03_mul_star.py

# TODO: 在下面写代码


# 下面是测试（不要改）。写好 mul 后直接运行本文件。
def mul(x,*args):
    result=x
    for n in args:
        result=result*n
    return result
print("mul(5) =", mul(5))
print("mul(5, 6) =", mul(5, 6))
print("mul(5, 6, 7) =", mul(5, 6, 7))
print("mul(5, 6, 7, 9) =", mul(5, 6, 7, 9))
if mul(5) != 5:
    print("mul(5)测试失败!")
elif mul(5, 6) != 30:
    print("mul(5, 6)测试失败!")
elif mul(5, 6, 7) != 210:
    print("mul(5, 6, 7)测试失败!")
elif mul(5, 6, 7, 9) != 1890:
    print("mul(5, 6, 7, 9)测试失败!")
else:
    try:
        mul()
        print("mul()测试失败!")
    except TypeError:
        print("测试成功!")
