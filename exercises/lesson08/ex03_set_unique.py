# 编程题 3：set 去重
#
# 要求：
#   1. 有一个 list（里面有重复）：
#        raw = ["李宏", "王五", "李宏", "赵六", "王五"]
#   2. 用 set(raw) 得到不重复的名字，存到 names
#   3. 打印 names
#   4. 打印去重后有多少人：len(names)
#
# 提示：set 没有顺序，打印出来的顺序可能和 list 不一样，这是正常的。
#
# 运行：python exercises/lesson08/ex03_set_unique.py

# TODO: 在下面写代码
raw = ["李宏", "王五", "李宏", "赵六", "王五"]
names=set(raw)
print(names)
print(f'去重后有{len(names)}人')
