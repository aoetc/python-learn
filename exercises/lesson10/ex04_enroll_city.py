# 编程题 4：命名关键字
#
# 要求：
#   1. 定义 enroll(name, *, city)
#      打印一行，能看出 name 和 city 即可，例如：李宏 报名城市=杭州
#   2. 只调用这一次（必须带名字）：
#        enroll("李宏", city="杭州")
#   3. 不要写成 enroll("李宏", "杭州")，那种会报错
#
# 运行：python exercises/lesson10/ex04_enroll_city.py

# TODO: 在下面写代码
def enroll(name,*,city):
    print(f'{name} 报名城市={city}')
enroll("李宏",city="杭州")