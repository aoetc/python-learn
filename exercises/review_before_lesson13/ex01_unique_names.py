# 复习编程 1：set 去重
#
# 要求：
#   1. 定义 unique_names(names)
#      参数 names 是 list，例如 ["李宏", "李宏", "王五"]
#      返回去重后的 list（顺序不要求；用 set 即可）
#   2. 打印 unique_names(["李宏", "李宏", "王五"]) 的长度，应为 2
#   3. 再打印这个结果本身（能看出两个名字即可）
#
# 运行：python exercises/review_before_lesson13/ex01_unique_names.py

# TODO: 在下面写代码
def unique_names(names):
    return list(set(names))
print(len(unique_names(["李宏","李宏","王五"])))
print(unique_names(["李宏","李宏","王五"]))