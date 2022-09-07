package com.elaine.mycoroutine

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class TestCoroutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_coroutine)
        testContext2()
    }

    fun useAsyncTask() {
        @SuppressLint("StaticFieldLeak")
        val test = object : AsyncTask<Void, Void, String>() {

            override fun doInBackground(vararg p0: Void?): String? {
                //请求网络或者数据库
                return "test"
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                //得到数据进行UI渲染绘制
                Log.e("result===", result + "")
            }
        }.execute()
    }

    fun useCoroutine() {
        GlobalScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                //请求网络或者数据库
            }
            //得到数据进行UI渲染绘制
            Log.e("result===", result.toString())
        }
    }

    fun testRunBlocking() {
        runBlocking {
            val result = async(start = CoroutineStart.DEFAULT) {

            }
        }
    }

    /**
     * 添加了所有元素的CoroutineContext
     */
    private val job = Job()

    private val exception = CoroutineExceptionHandler { _, throwable ->
        Log.e("exception===", throwable.message ?: "unKnow")
    }

    fun testContext() {
        GlobalScope.launch(Dispatchers.Main + job + exception + CoroutineName("testContext")) {
            delay(1000)
            Log.e("testContext===", "launch")
        }
    }

    /**
     * 获取CoroutineContext的默认值
     */
    fun testContext2() {
        val scope = CoroutineScope(Job()+CoroutineName("testContext2"))
        scope.launch{
            delay(1000)
            Log.e("testContext2===", "name:" + coroutineContext[CoroutineName])
            Log.e("testContext2===", "dispatcher:+ ${Thread.currentThread().name}")
        }
    }
}