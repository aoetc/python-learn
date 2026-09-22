# dca-ledger 入口
# 在 dca-ledger 目录下运行：
#   ../.venv/bin/python main.py
#
# 软设巩固：路径只在 ledger_path() 里算一次（可维护）
#
# TODO（第 28 天）：sys.argv 命令行 —— 见 notes/lesson28_实操_sys_argv.md

import os
import sys


def ledger_path():
    """账本 CSV 的完整路径（相对本文件所在目录）。"""
    base = os.path.dirname(os.path.abspath(__file__))
    return os.path.join(base, "data", "ledger.csv")


def do_add(date=None,money_text=None):
    try:
        if date is None:
            date = input("请输入日期：")
        if money_text is None:
            money_text=input("请输入金额:")
        money=float(money_text)
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

def do_find(date_text=None):
    if date_text is None:
        date0 = input("请输入你要查找的日期：").strip()
    else:
        date0=date_text.strip()
    path = ledger_path()
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
    # 终端写了参数 → 用参数当命令；否则还走菜单
    # 例：python dca-ledger/main.py list
    #      sys.argv == [脚本名, "list"]
    if len(sys.argv) >= 2:
        cmd = sys.argv[1]
    else:
        print("dca-ledger:简易流水账")
        print("可用命令:")
        print("  add     - 记一笔(日期+金额)")
        print("  list    - 查看流水")
        print("  summary - 笔数和合计")
        print("  find - 查找具体天数的开销")
        cmd = input("请输入命令：")

    if cmd == "add":
        if len(sys.argv)>=4:
            do_add(sys.argv[2],sys.argv[3])
        else:
            do_add()
    elif cmd == "list":
        do_list()
    elif cmd == "summary":
        do_summary()
    elif cmd == "find":
        if len(sys.argv)>=3:
            do_find(sys.argv[2])
        else:
            do_find()
    else:
        print("未知功能")

if __name__ == "__main__":
    main()
