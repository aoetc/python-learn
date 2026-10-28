import os
def ledger_path():
    """账本 CSV 的完整路径（相对本文件所在目录）。"""
    base = os.path.dirname(os.path.abspath(__file__))
    return os.path.join(base, "data", "ledger.csv")