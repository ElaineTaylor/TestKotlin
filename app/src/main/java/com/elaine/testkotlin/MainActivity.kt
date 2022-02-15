package com.elaine.testkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elaine.mygzh.pagefour.testPeople
import com.elaine.mygzh.pagetwo.testApply
import com.elaine.mygzh.pagetwo.testRepeat
import com.elaine.mygzh.pagetwo.testTask

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testPeople()
    }
}