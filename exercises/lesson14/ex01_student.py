# 编程题 1：Student 类
#
# 要求：
#   1. 定义 class Student
#   2. __init__(self, name, score)：保存 self.name、self.score
#   3. 方法 print_score(self)：用 f-string 打印  名字: 分数
#   4. 造两个实例并调用 print_score：
#        Student("李宏", 90)
#        Student("王五", 59)
#
# 运行：python exercises/lesson14/ex01_student.py

# TODO: 在下面写代码
class Student:
    def __init__(self,name,score):
        self.name=name
        self.score=score
    def print_score(self):
        print(f'{self.name}:{self.score}')
a=Student("李宏", 90)
b=Student("王五", 59)
a.print_score()
b.print_score()