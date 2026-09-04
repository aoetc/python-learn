# 编程题 4（加分）：关键字参数 **kw
#
# 要求：
#   1. 定义 person(name, age, **kw)
#      打印三行或一行均可，但要能看出 name、age、kw
#   2. 调用两次：
#        person("李宏", 19)
#        person("李宏", 19, city="杭州", major="软件工程")
#   3. 第一次 kw 应是 {}；第二次 kw 里有 city 和 major
#
# 运行：python exercises/lesson09/ex04_kw_person.py

# TODO: 在下面写代码
def person(name,age,**kw):
    print (f'name:{name},age:{age},other:{kw}')
person("李宏",19)
person("李宏", 19, city="杭州", major="软件工程")