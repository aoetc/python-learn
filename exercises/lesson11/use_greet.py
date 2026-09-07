# 使用模块：不要把 greet 再写一遍，用 import
#
# 要求：
#   1. 从同目录导入 greet_mod（提示二选一，用一种即可）：
#        import greet_mod
#        然后 greet_mod.greet("李宏")
#      或：
#        from greet_mod import greet
#        然后 greet("李宏")
#   2. 打印调用结果
#
# 说明：请在 exercises/lesson11/ 目录下运行，或从该目录导入。
# 若在仓库根目录运行本文件报错找不到模块，先：
#   cd exercises/lesson11
#   python use_greet.py
#
# 运行：python use_greet.py（在 lesson11 目录内）

# TODO: 在下面写代码
import greet_mod
result=greet_mod.greet("李宏")
print(f'{result}')