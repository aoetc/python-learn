# 编程题 3：账本条目类（小铺垫）
#
# 要求：
#   1. 定义 class LedgerEntry
#   2. __init__(self, date, amount)：
#        self.date = date      # 字符串，如 "2026-09-13"
#        self.amount = amount  # 数字，如 100
#   3. 方法 summary(self)：返回字符串，例如：
#        2026-09-13: 100
#      （用 return，不要只 print）
#   4. 造一个实例，print(它的 summary())
#
# 运行：python exercises/lesson14/ex03_ledger_entry.py

# TODO: 在下面写代码
class LedgerEntry:
    def __init__(self,date,amount):
        self.date=date
        self.amount=amount
    def summary(self):
        return (f'{self.date}:{self.amount}')
a=LedgerEntry('2026-09-13',100)
print(a.summary())