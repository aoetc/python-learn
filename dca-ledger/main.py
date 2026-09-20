# dca-ledger 入口
#
# 第 19 天：打印用法（已完成）
# 第 20 天：实现 add → 追加写入 data/ledger.csv
# 要求见：notes/lesson20_实操_add写CSV.md
#
# 在 dca-ledger 目录下运行：
#   ../.venv/bin/python main.py
#
# 软设巩固：路径只在 ledger_path() 里算一次（可维护）

import os


def ledger_path():
    """账本 CSV 的完整路径（相对本文件所在目录）。"""
    base = os.path.dirname(os.path.abspath(__file__))
    return os.path.join(base, "data", "ledger.csv")


# TODO（第 24 天）：
#   在 README.md 写「验收清单」5 条（见 notes/lesson24_实操_README验收.md）
#   可选：给 add 的金额加上非数字保护
def do_add():
    date = input("请输入日期：")
    try:
        money = float(input("请输入金额："))
    except ValueError:
        print("金额无效，请输入数字（整数或小数）")
        return  # 不写文件，直接结束本次 add

    path = ledger_path()

    if os.path.exists(path):
        with open(path, "a", encoding="utf-8") as f:
            f.write(f"{date},{money}\n")
    else:
        with open(path, "w", encoding="utf-8") as f:
            f.write("date,money\n")
            f.write(f"{date},{money}\n")
    print("已保存")

def do_list():
    path = ledger_path()
    try:
        with open(path,"r",encoding="utf-8") as f:
            lines=f.readlines()
            for line in lines:
                print(line.strip())
    except FileNotFoundError:
        print("还没有数据,请先add")

def do_summary():
    count=0
    summary=0.0
    path = ledger_path()
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
    path = ledger_path()
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
