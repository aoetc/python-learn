# 编程题 1：先写再读
#
# 要求：
#   1. 用 with open(..., "w", encoding="utf-8") 把一行
#      「李宏在学文件读写」写进 exercises/lesson13/demo.txt
#      （write 时字符串末尾可加 \n）
#   2. 再用 with open(..., "r", encoding="utf-8") 读回来
#   3. print 读到的内容
#
# 在仓库根目录运行：
#   python exercises/lesson13/ex01_write_read.py

# TODO: 在下面写代码
with open('exercises/lesson13/demo.txt','w',encoding="utf-8") as f:
    f.write('李宏在学文件读写')
with open('exercises/lesson13/demo.txt','r',encoding="utf-8") as f:
    print(f.read())