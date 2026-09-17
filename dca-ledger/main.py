# dca-ledger 入口
#
# 第 19 天：打印用法（已完成）
# 第 20 天：实现 add → 追加写入 data/ledger.csv
# 要求见：notes/lesson20_实操_add写CSV.md
#
# 在 dca-ledger 目录下运行：
#   ../.venv/bin/python main.py

# TODO（第 20 天）：
#   1. 写 do_add()：input 日期和金额，追加到 data/ledger.csv
#   2. 改 main()：菜单 + 输入 add 时调用 do_add()
#   3. 不要做 list（明天）
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

    
def main():
    print("dca-ledger:简易流水账")
    print("下面功能以后会做:")
    print("add--记一笔(日期+金额)")
    print("list--查看流水")
    print("今只是骨架,具体功能没做")
    cmd=input("请输入命令")
    if cmd== 'add':
        do_add()
    elif cmd== 'list':
        print("list还没做")
    else:
        print("未知功能")

if __name__ == "__main__":
    main()
