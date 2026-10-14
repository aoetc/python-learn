# 力扣 242. 有效的字母异位词
# https://leetcode.cn/problems/valid-anagram/
# 第 32 天：用 dict 统计字母出现次数
#
# 题意：s 和 t 是否互为字母异位词（字母种类和个数都相同）
# 自己实现 class Solution / 函数均可；力扣通过后把代码贴进来。


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t):
            return False
        count={}
        for ch in s:
            if ch not in count:
                count[ch]=0
            count[ch]=count[ch]+1
        for ch in t:
            if ch not in count:
                count[ch]=0
            count[ch]=count[ch]-1
        for v in count.values():
            if v!=0:
                return False
        return True