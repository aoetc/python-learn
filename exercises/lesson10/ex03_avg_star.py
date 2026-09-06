# 编程题 3：可变参数 — 平均分
#
# 要求：
#   1. 定义 avg(x, *args)：至少一个分数，返回平均数（可以是小数）
#   2. avg() 应报错 TypeError（一个都不传不行）
#   3. 打印：
#        avg(90)           应是 90.0 或 90
#        avg(90, 80)       应是 85.0
#        avg(90, 80, 70)   应是 80.0
#
# 提示：个数 = 1 + len(args)；总和先加 x 再 for 加 args 里的数
#
# 运行：python exercises/lesson10/ex03_avg_star.py

# TODO: 在下面写代码
def avg(x, *args):
    sum=x
    for i in args:
        sum+=i
    average=sum/(1 + len(args))
    return average
print(f'avg(90)应该是{avg(90)}')
print(f'avg(90,80)应该是{avg(90,80)}')
print(f'avg(90,80,70)应该是{avg(90,80,70)}')