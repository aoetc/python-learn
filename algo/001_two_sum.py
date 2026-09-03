# 力扣 1. 两数之和
# 链接：https://leetcode.cn/problems/two-sum/
#
# 题目：给一个整数 list nums 和一个整数 target，
# 找出两个数的下标 i、j，使得 nums[i] + nums[j] == target。
# 每种输入只有一组答案，同一个元素不能用两次。
#
# 你要做的：
#   1. 打开上面的链接，语言选 Python3
#   2. 在力扣网页里自己写、自己提交
#   3. 通过后，把 Solution 里的代码复制到下面（不要抄题解）
#   4. 用三句话写思路（用了 list 还是 dict）
#
# 运行本文件（可选，用来本地试几个例子）：
#   python algo/001_two_sum.py

# 思路（通过后自己填）：
# 1.
# 2.
# 3.

from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # TODO: 先在力扣网页写。通过后再粘贴到这里。
        pass
        n=len(nums)
        for i in range(n):
            for j in range(i+1,n):
                if nums[i]+nums[j]==target:
                    return([i,j])
#双重循环，暴力解法