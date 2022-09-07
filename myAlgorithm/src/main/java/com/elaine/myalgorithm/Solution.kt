package com.elaine.myalgorithm

import android.util.Log

object Solution {

    /**
     * 1672. 最富有客户的资产总量
     *
     * 题目：给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。

    客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。

    示例 1：
    输入：accounts = [[1,2,3],[3,2,1]]
    输出：6
    解释：
    第 1 位客户的资产总量 = 1 + 2 + 3 = 6
    第 2 位客户的资产总量 = 3 + 2 + 1 = 6
    两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。

    示例 2：
    输入：accounts = [[1,5],[7,3],[3,5]]
    输出：10
    解释：
    第 1 位客户的资产总量 = 6
    第 2 位客户的资产总量 = 10
    第 3 位客户的资产总量 = 8
    第 2 位客户是最富有的，资产总量是 10

    示例 3：
    输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
    输出：17

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/richest-customer-wealth
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var max = 0
        if (accounts.isNotEmpty()) {
            val m = accounts.size
            for (i in 0 until m) {
                val inAccount = accounts[i]
                val n = inAccount.size
                var add = 0
                for (j in 0 until n) {
                    add += inAccount[j]
                }
                if (add > max) {
                    max = add
                }
            }
        }
        return max
    }

    fun testMaximumWealth() {
//        val intArray = arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))//6
//        val intArray = arrayOf(intArrayOf(1, 5), intArrayOf(7, 3), intArrayOf(3, 5))//10
        val intArray = arrayOf(intArrayOf(2, 8, 7), intArrayOf(7, 1, 3), intArrayOf(1, 9, 5))//17
        Log.e("result===max===", maximumWealth(intArray).toString())
    }

    /**
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    你可以按任意顺序返回答案。

    示例 1：

    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    示例 2：

    输入：nums = [3,2,4], target = 6
    输出：[1,2]
    示例 3：

    输入：nums = [3,3], target = 6
    输出：[0,1]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/two-sum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var result = intArrayOf()
        nums.forEachIndexed { index, num ->
            for (i in index + 1 until nums.size) {
                if (num + nums[i] == target) {
                    result = intArrayOf(index, i)
                }
            }
        }
        return result
    }

    fun testTwoSum() {
//        val result = twoSum(intArrayOf(2, 7, 11, 15), 9)//[0,1]
//        val result = twoSum(intArrayOf(3,2,4), 6)//[1,2]
        val result = twoSum(intArrayOf(3, 3), 6)//[0,1]
//        val result = twoSum(intArrayOf(3, 2, 3), 6)//[0,2]
        Log.e("result===", "" + result[0] + ":" + result[1])
    }


    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

    回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

    例如，121 是回文，而 123 不是。

    示例 1：

    输入：x = 121
    输出：true
    示例2：

    输入：x = -121
    输出：false
    解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    示例 3：

    输入：x = 10
    输出：false
    解释：从右向左读, 为 01 。因此它不是一个回文数。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/palindrome-number
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    fun isPalindrome(x: Int): Boolean {
        return false
    }

    /**
     *给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。

    返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。

    两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。

    示例 1：

    输入：s = "loveleetcode", c = "e"
    输出：[3,2,1,0,1,0,0,1,2,2,1,0]
    解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
    距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
    距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
    对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
    距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
    示例 2：

    输入：s = "aaab", c = "b"
    输出：[3,2,1,0]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
//    fun shortestToChar(s: String, c: Char): IntArray {
//        var cIndexArray= MutableList()
//        s.forEachIndexed { index, char ->
//            if (char == c){
//                intArrayOf(index)
//            }
//        }
//    }

    /**
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。

    示例 1：

    输入：nums = [1,2,3,1]
    输出：true
    示例 2：

    输入：nums = [1,2,3,4]
    输出：false
    示例3：

    输入：nums = [1,1,1,3,3,4,3,2,4,2]
    输出：true

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/contains-duplicate
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    fun containsDuplicate(nums: IntArray): Boolean {
        if (nums.isNotEmpty()) {
            var size = 0
            var nowNum: Int
            for (index in nums.indices) {
                nowNum = nums[index]
                for (nextIndex in index + 1 until nums.size) {
                    if (nowNum == nums[nextIndex]) {
                        size++
                        break
                    }
                }
                if (size > 0) {
                    break
                }
            }
            return size > 0
        } else {
            return false
        }
    }

    /**
     * 53. 最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    子数组 是数组中的一个连续部分。

    示例 1：

    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组[4,-1,2,1] 的和最大，为6 。
    示例 2：

    输入：nums = [1]
    输出：1
    示例 3：

    输入：nums = [5,4,-1,7,8]
    输出：23

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/maximum-subarray
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
//    fun maxSubArray(nums: IntArray): Int {
//
//    }
}