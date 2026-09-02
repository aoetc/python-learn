# 编程题 2：f-string 名片
#
# 要求：
#   1. 用 input 读入：姓名、年龄、城市（都是普通字符串/整数）
#   2. 用**一个** f-string 打印多行「名片」，例如：
#        ==========
#        姓名：李宏
#        年龄：19
#        城市：杭州
#        ==========
#   提示：f-string 里可以写 \n 换行
#
# 运行：python exercises/lesson06/ex02_fstring_card.py

# TODO: 在下面写代码
name=input('姓名：')
age=int(input('年龄：'))
city=input('城市：')
print(f'==========\n姓名:{name}\n年龄:{age}\n城市:{city}\n==========')

