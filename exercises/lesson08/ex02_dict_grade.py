# 编程题 2：dict 存成绩
#
# 要求：
#   1. 创建 dict：
#        grade = {"李宏": 90, "王五": 85, "赵六": 72}
#   2. 打印李宏的分数（用 grade["李宏"]）
#   3. 把赵六的分数改成 80，再打印整个 grade
#   4. 用 input 读入一个姓名 name
#      如果 name in grade：打印这个人的分数
#      否则：打印「查无此人」
#
# 运行：python exercises/lesson08/ex02_dict_grade.py

# TODO: 在下面写代码
grade = {"李宏": 90, "王五": 85, "赵六": 72}
print(grade["李宏"])
grade["赵六"] = 80
print(grade)
name =input('请输入姓名:')
if name in grade:
    print(grade[name])
else:
    print('查无此人')