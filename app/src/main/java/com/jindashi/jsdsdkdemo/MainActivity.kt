package com.jindashi.jsdsdkdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.jindashi.http.RequestStatus
import com.jindashi.jsdsdkdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        viewBinding.edit.addTextChangedListener {

        }

        viewModel.newsLiveData.observe(this, Observer {
            when(it.requestStatus) {
                RequestStatus.SUCCESS -> {
                    Log.e("aaaddd", it.data.toString())
                }
            }
        })
    }
}