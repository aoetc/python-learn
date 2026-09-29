# 第 29 天：用 assert 测「拆一行 / 合计金额」
# 跑法（仓库根目录）：
#   .venv/bin/python exercises/lesson29/parse_and_sum.py
#
# 要求：实现下面两个函数，并在文末写至少 3 条 assert。
# 全过 = 安静结束（或只有你自己的 print）；失败 = AssertionError。


def parse_line(line):
    """把 '2026-09-22,80' 拆成 (日期字符串, 金额 float)。"""
    # TODO：strip → split(",") → float 第二段 → return
    parts=line.split(",")
    date=parts[0]
    money=float(parts[1])
    return date,money

def sum_money(amounts):
    """amounts 是金额 list，返回合计；空 list 返回 0.0。"""
    # TODO
    summary=0.0
    if (amounts==[]):
        return 0.0
    else :
        for m in amounts:
            summary+=m
        return summary



assert parse_line("2026-09-22,80") == ("2026-09-22", 80.0)
assert sum_money([80,90]) ==170
assert sum_money([]) == 0.0

print("若你看到这行且上面 assert 都没炸：小测试通过")
