# 编程题 3：encode 与 decode 往返
#
# 要求：
#   1. s = "Agent工程师"
#   2. b = s.encode("utf-8")
#   3. s2 = b.decode("utf-8")
#   4. 打印三行：
#        原字符串: ...
#        字节形式: ...（会看到 b'...'）
#        还原后: ...
#   5. 再打印：字符数 len(s) 和 utf-8 字节数 len(b)
#
# 运行：python exercises/lesson06/ex03_encode_roundtrip.py

# TODO: 在下面写代码

s='Agent工程师'
b=s.encode('utf-8')
s2=b.decode('utf-8')
print(f'原字符串:{s}')
print(f'字节形式:{b}')
print(f'还原后:{s2}')
print(f'字符数:{len(s)}')
print(f'utf-8字节数:{len(b)}')
