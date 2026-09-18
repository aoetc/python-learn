# dca-ledger 入口
#
# 第 19 天：打印用法（已完成）
# 第 20 天：实现 add → 追加写入 data/ledger.csv
# 要求见：notes/lesson20_实操_add写CSV.md
#
# 在 dca-ledger 目录下运行：
#   ../.venv/bin/python main.py

# TODO（第 23 天 · 二选一）：
#   A. do_find()：输入日期，只打印匹配行
#   B. do_delete()：删除最后一笔账并写回文件
# 要求见：notes/lesson23_实操_筛选或删除.md
# 做完一种即可；菜单和 README 补上对应命令
def do_add():
    import os

    date = input("请输入日期")
    money = float(input("请输入金额"))

    # 相对 main.py 所在目录找 data/，这样从仓库根目录点 Run 也对
    base = os.path.dirname(os.path.abspath(__file__))
    path = os.path.join(base, "data", "ledger.csv")

    if os.path.exists(path):
        with open(path, "a", encoding="utf-8") as f:
            f.write(f"{date},{money}\n")
    else:
        with open(path, "w", encoding="utf-8") as f:
            f.write("date,money\n")
            f.write(f"{date},{money}\n")
    print("已保存")

def do_list():
    import os
    base = os.path.dirname(os.path.abspath(__file__))
    path = os.path.join(base, "data", "ledger.csv")
    try:
        with open(path,"r",encoding="utf-8") as f:
            lines=f.readlines()
            for line in lines:
                print(line.strip())
    except FileNotFoundError:
        print("还没有数据,请先add")

def do_summary():
    import os
    count=0
    summary=0.0
    base = os.path.dirname(os.path.abspath(__file__))
    path = os.path.join(base, "data", "ledger.csv")
    try:
        with open(path,"r",encoding="utf-8") as f:
            lines=f.readlines()
            first=True
            for line in lines:
                if first:
                    first=False
                    continue
                line=line.strip()
                if line=="":
                    continue
                try:
                    parts = line.split(",")
                    money = float(parts[1])
                    summary += money
                    count += 1
                except ValueError:
                    print("跳过坏行:", line)
            print("笔数:",count)
            print("总额",summary)
    except FileNotFoundError:
        print("还没有数据,请先add")

def do_find():
    import os

    base = os.path.dirname(os.path.abspath(__file__))
    path = os.path.join(base, "data", "ledger.csv")
    date0 = input("请输入你要查找的日期：").strip()
    found = False
    try:
        with open(path, "r", encoding="utf-8") as f:
            lines = f.readlines()
        for i, line in enumerate(lines):
            if i == 0:
                continue  # 跳过表头
            line = line.strip()
            if line == "":
                continue
            parts = line.split(",")
            if parts[0] == date0:
                print(line)
                found = True
        if not found:
            print("没有这天的记录")
    except FileNotFoundError:
        print("还没有数据,请先add")
    
def main():
    print("dca-ledger:简易流水账")
    print("可用命令:")
    print("  add     - 记一笔(日期+金额)")
    print("  list    - 查看流水")
    print("  summary - 笔数和合计")
    print("  find - 查找具体天数的开销")
    cmd = input("请输入命令：")
    if cmd == "add":
        do_add()
    elif cmd == "list":
        do_list()
    elif cmd == "summary":
        do_summary()
    elif cmd == "find":
        do_find()
    else:
        print("未知功能")

if __name__ == "__main__":
    main()
