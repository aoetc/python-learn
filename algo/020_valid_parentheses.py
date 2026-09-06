# 力扣 20. 有效的括号
# 链接：https://leetcode.cn/problems/valid-parentheses/
#
# 题目：给定只包含 '(', ')', '{', '}', '[', ']' 的字符串 s，
# 判断括号是否有效。
# 有效需同时满足：
#   - 左括号必须用相同类型的右括号闭合
#   - 左括号必须以正确的顺序闭合（后开的先关）
#   - 每个右括号都有对应的左括号
#
# 你要做的：
#   1. 打开上面的链接，语言选 Python3
#   2. 在力扣网页里自己写、自己提交
#   3. 通过后，把 Solution 里的代码复制到下面
#   4. 用几句话写思路（篮子 + dict 配对）
#
# 运行本文件（可选）：
#   python algo/020_valid_parentheses.py

# 思路（通过后自己填）：
# 1.
# 2.
# 3.

class Solution:
    def isValid(self, s: str) -> bool:
        # TODO: 通过后把力扣上的代码粘贴到这里
        pair = {")": "(","]": "[","}": "{",}
        basket=[]
        front="([{"
        for i in range(len(s)):
            if s[i] in front:
                basket.append(s[i])
            else:
                if basket==[]:
                    return False
                need=pair[s[i]]
                if basket[-1] == need:
                    basket.pop()
                else :
                    return False 
        return basket==[]









# 本地小测（可选）
if __name__ == "__main__":
    sol = Solution()
    print(sol.isValid("()"))      # True
    print(sol.isValid("()[]{}"))  # True
    print(sol.isValid("(]"))      # False
    print(sol.isValid("([])"))    # True
    print(sol.isValid("([)]"))    # False
