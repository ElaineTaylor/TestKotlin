package com.elaine.myalgorithm

import android.util.Log


/**
 * 排序
 */
object DifferentSort {

    /**
     * 冒泡排序
     * 排序前：[2,5,8,4,1,7,9,3,6]
     * 排序后：[1,2,3,4,5,6,7,8,9]
     */
    fun bubbleSort(numArray: IntArray): IntArray {
        for (index in 1 until numArray.size) {
            var flag = true
            for (i in 0 until numArray.size - index) {
                if (numArray[i] > numArray[i + 1]) {
                    val temp = numArray[i]
                    numArray[i] = numArray[i + 1]
                    numArray[i + 1] = temp
                    flag = false
                }
            }
            Log.e("bubbleSort===", numArray.contentToString())
            if (flag) break
        }
        return numArray
    }

    /**
     * 选择排序
     * 排序前：[2,5,8,4,1,7,9,3,6]
     * 排序后：[1,2,3,4,5,6,7,8,9]
     */
    fun selectSort(numArray: IntArray): IntArray {
        for (i in numArray.indices) {
            var minIndex = i
            var j = i + 1
            while (j in numArray.indices) {
                if (numArray[j] < numArray[minIndex]) {
                    minIndex = j
                }
                j++
            }
            if (i != minIndex) {
                val temp = numArray[i]
                numArray[i] = numArray[minIndex]
                numArray[minIndex] = temp
            }
            Log.e("selectSort===", numArray.contentToString() + "===" + i)
        }
        return numArray
    }

    /**
     * 插入排序
     * 排序前：[2,5,8,4,1,7,9,3,6]
     * 排序后：[1,2,3,4,5,6,7,8,9]
     */
    fun insertSort(numArray: IntArray): IntArray {
        for (i in 1 until numArray.size) {
            val tmp: Int = numArray[i]
            var j = i
            while (j > 0 && tmp < numArray[j - 1]) {
                numArray[j] = numArray[j - 1]
                j--
            }
            if (j != i) {
                numArray[j] = tmp
            }
            Log.e("insertSort===", numArray.contentToString() + "===" + i)
        }
        return numArray
    }

    /**
     * 归并排序
     * 排序前：[2,5,8,4,1,7,9,3,6]
     * 排序后：[1,2,3,4,5,6,7,8,9]
     */
    fun mergeSort(numArray: IntArray, left: Int, right: Int): IntArray {
        if (left == right) return intArrayOf(numArray[left])

        val mid: Int = left + (right - left) / 2
        //左有序数组
        val leftArr = mergeSort(numArray, left, mid)
        //右有序数组
        val rightArr = mergeSort(numArray, mid + 1, right)
        //新有序数组
        val newNum = IntArray(leftArr.size + rightArr.size)

        var m = 0
        var i = 0
        var j = 0
        while (i < leftArr.size && j < rightArr.size) {
            newNum[m++] = if (leftArr[i] <= rightArr[j]) leftArr[i++] else rightArr[j++]
        }
        while (i < leftArr.size) newNum[m++] = leftArr[i++]
        while (j < rightArr.size) newNum[m++] = rightArr[j++]
        Log.e("mergeSort===", newNum.contentToString())
        return newNum
    }

    /**
     * 希尔排序
     * 排序前：[2,5,8,4,1,7,9,3,6]
     * 排序后：[1,2,3,4,5,6,7,8,9]
     */
    fun shellSort(numArray: IntArray): IntArray {
        var step = numArray.size / 2
        while (1 <= step) {
            for (i in step until numArray.size) {
                var j = i - step
                val tmp = numArray[i]
                while (j >= 0 && tmp < numArray[j]) {
                    numArray[j + step] = numArray[j]
                    j -= step
                }
                numArray[j + step] = tmp
            }
            Log.e("shellSort===", numArray.contentToString() + "===step:" + step)
            step /= 2
        }
        return numArray
    }

    /**
     * 快速排序
     */
    fun quickSort(numArray: IntArray) {

    }
}