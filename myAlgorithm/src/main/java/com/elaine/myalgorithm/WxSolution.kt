package com.elaine.myalgorithm

object WxSolution {

    /**
     * 基本二分查找
     * numArray 数组
     * target 目标值
     *
     * @return 目标值的位置，没有匹配到则为-1
     */
    fun binaryForTarget(numArray: IntArray, target: Int): Int {
        if (numArray.isEmpty()) {
            return -1
        }
        var left = 0
        var right = numArray.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2 //防止溢出
            when {
                numArray[mid] == target -> {
                    return mid
                }
                numArray[mid] > target -> {
                    right = mid - 1
                }
                numArray[mid] < target -> {
                    left = mid + 1
                }
            }
        }
        return -1
    }

    /**
     * 基本二分查找(最左侧)
     * numArray 数组
     * target 目标值
     *
     * @return 目标值的位置，没有匹配到则为-1
     */
    fun binaryForTargetLeft(numArray: IntArray, target: Int): Int {
        if (numArray.isEmpty()) {
            return -1
        }
        var left = 0
        var right = numArray.size
        while (left < right) {
            val mid = left + (right - left) / 2 //防止溢出
            when {
                numArray[mid] == target -> {
                    right = mid
                }
                numArray[mid] > target -> {
                    right = mid
                }
                numArray[mid] < target -> {
                    left = mid + 1
                }
            }
        }
        if (left == numArray.size) return -1
        return if (numArray[left] == target) left else -1
    }

    /**
     * 基本二分查找(最右侧)
     * numArray 数组
     * target 目标值
     *
     * @return 目标值的位置，没有匹配到则为-1
     */
    fun binaryForTargetRight(numArray: IntArray, target: Int): Int {
        if (numArray.isEmpty()) {
            return -1
        }
        var left = 0
        var right = numArray.size
        while (left < right) {
            val mid = left + (right - left) / 2 //防止溢出
            when {
                numArray[mid] == target -> {
                    left = mid + 1
                }
                numArray[mid] > target -> {
                    right = mid
                }
                numArray[mid] < target -> {
                    left = mid + 1
                }
            }
        }
        if (left == 0) return -1
        return if (numArray[left - 1] == target) left - 1 else -1
    }


}