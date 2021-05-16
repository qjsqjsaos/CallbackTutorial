package com.example.callbacktutorial

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.callbacktutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var mBinding: ActivityMainBinding? = null
    val binding get() = mBinding!!

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "MainActivity - onCreate() called")

        var sooyeol = "sooyeol"

        someCallBackMethod(sooyeol, completion = {
            //매개변수로 들어간 completion이 smeCallBackMethod안에서 실행될때, 액션을 넣는 곳

            Log.d(TAG, "MainActivity - 컴플레션 블럭 호출됨 it: $it")
        })

    }

    //콜백 함수 정의하기
    private fun someCallBackMethod(sooyeol: String, completion: (String) -> Unit) { //자바에 보이드와 같음
        Log.d(TAG, "MainActivity - someCallBackMethod() called")

        //핸들러로 1초가 지나면 실행
        Handler(Looper.myLooper()!!).postDelayed({
            completion(sooyeol)
        }, 5000L)
    }
}