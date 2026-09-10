# 复习编程 3：安全转整数
#
# 要求：
#   1. 定义 safe_int(text)
#      能转成 int 就返回整数
#      不能转（ValueError）就返回 None
#   2. 打印：
#        safe_int("60")   → 60
#        safe_int("abc")  → None
#        safe_int("3.14") → None（int("3.14") 会失败，这是正常的）
#
# 提示：
#   try:
#       return int(text)
#   except ValueError:
#       return None
#
# 运行：python exercises/review_before_lesson13/ex03_safe_int.py

# TODO: 在下面写代码
