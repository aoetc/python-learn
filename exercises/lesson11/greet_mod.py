# 模块文件：别人（或 use_greet.py）会 import 这里的函数
#
# 要求：
#   1. 定义 greet(name)，返回字符串，例如：你好，李宏
#   2. 文件底部写：
#        if __name__ == "__main__":
#            print(greet("自测"))
#      这样：直接运行本文件会打印；被 import 时不应打印
#
# 运行：python exercises/lesson11/greet_mod.py

# TODO: 在下面写代码
def greet(name):
    return f'你好,{name}'
if __name__ == "__main__":
    print(greet("自测"))