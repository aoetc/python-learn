# 编程题 2：及格判断做成方法
#
# 要求：
#   1. 定义 class Student，__init__(self, name, score) 同上
#   2. 方法 is_pass(self)：
#        score >= 60 返回 True，否则返回 False
#   3. 打印：
#        Student("李宏", 90).is_pass()
#        Student("王五", 59).is_pass()
#
# 运行：python exercises/lesson14/ex02_is_pass.py

# TODO: 在下面写代码
class Student:
    def __init__(self,name,score):
        self.name=name
        self.score=score
    def is_pass(self):
        if self.score>=60:
            return True
        else:
            return False
a=Student("李宏", 90)
b=Student("王五", 59)
print(a.is_pass())
print(b.is_pass())