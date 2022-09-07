package com.elaine.testkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.elaine.myalgorithm.DifferentSort
import com.elaine.myalgorithm.MyArray
import com.elaine.myalgorithm.Solution
import com.elaine.myalgorithm.WxSolution
import com.elaine.mycoroutine.TestCoroutineActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, TestCoroutineActivity::class.java))
//        Log.e("result===", MyArray.pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)).toString())
//        Log.e("result===", MyArray.pivotIndex(intArrayOf(1, 2, 3)).toString())
//        Log.e("result===", MyArray.pivotIndex(intArrayOf(2, 1, -1)).toString())
//        Log.e("result===", Solution.containsDuplicate(intArrayOf(1,2,3,1)).toString())
//        Log.e("result===", Solution.containsDuplicate(intArrayOf(1,2,3,4)).toString())
//        Log.e("result===", Solution.containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)).toString())

//        Log.e(
//            "result===binaryForTarget",
//            WxSolution.binaryForTarget(intArrayOf(1, 2, 3, 5, 7, 8, 10), 3).toString()
//        ) / 2
//
//
//        Log.e(
//            "result===binaryForTargetLeft",
//            WxSolution.binaryForTargetLeft(intArrayOf(1, 3, 3, 3, 7, 8, 10), 3).toString()
//        )//1
//        Log.e(
//            "result===binaryForTargetLeft",
//            WxSolution.binaryForTargetLeft(intArrayOf(1, 2, 3, 3, 7, 8, 10), 3).toString()
//        )//2
//        Log.e(
//            "result===binaryForTargetLeft",
//            WxSolution.binaryForTargetLeft(intArrayOf(1, 2, 3, 3, 7, 8, 8), 8).toString()
//        )//5
//
//
//        Log.e(
//            "result===binaryForTargetRight",
//            WxSolution.binaryForTargetRight(intArrayOf(1, 3, 3, 3, 7, 8, 10), 3).toString()
//        )//3
//        Log.e(
//            "result===binaryForTargetRight",
//            WxSolution.binaryForTargetRight(intArrayOf(1, 2, 3, 5, 7, 7, 10), 7).toString()
//        )//5
//        Log.e(
//            "result===binaryForTargetRight",
//            WxSolution.binaryForTargetRight(intArrayOf(1, 2, 3, 7, 7, 7, 10), 10).toString()
//        )//6

//        val result = DifferentSort.shellSort(intArrayOf(2, 5, 8, 4, 1, 7, 9, 3, 6))
//        result.forEach { Log.e("DifferentSort====", it.toString()) }


    }
}