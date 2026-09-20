# 力扣 217. 存在重复元素
# https://leetcode.cn/problems/contains-duplicate/
#
# 给定整数数组，若存在任何值出现至少两次，返回 True；
# 所有元素都不同，返回 False。
#
# 提示：用 set 记录已经见过的数。
#
# 通过后把题解函数写在下面，可自测几组 print。

# TODO: 写 class Solution / 函数 containsDuplicate
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        seen = set()
        for x in nums:          
            if x in seen:
                return True
            seen.add(x)
        return False

#class Solution:
#   def containsDuplicate(self, nums: List[int]) -> bool:
#       return len(set(nums))<len(nums)