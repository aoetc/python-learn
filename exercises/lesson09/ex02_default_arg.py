# 编程题 2：默认参数
#
# 要求：
#   1. 定义 greet(name, title="同学")
#      用 f-string 返回：你好，{title}{name}
#      例如 greet("李宏") → 你好，同学李宏
#           greet("李宏", "老师") → 你好，老师李宏
#   2. 打印上面两个例子的结果
#
# 运行：python exercises/lesson09/ex02_default_arg.py

# TODO: 在下面写代码
def grate(name, title="同学"):
    return f'你好，{title}{name}'
print(grate("李宏"))
print(grate("李宏","老师"))
