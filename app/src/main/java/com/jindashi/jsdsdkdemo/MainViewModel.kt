package com.jindashi.jsdsdkdemo

import androidx.lifecycle.*
import com.jindashi.http.*
import com.jindashi.jsdsdkdemo.http.*
import com.jindashi.jsdsdkdemo.lhb.AllData
import com.jindashi.jsdsdkdemo.lhb.LongHuBangAdvisoryBean
import com.jindashi.jsdsdkdemo.lhb.TestApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

/**
 * @author 李沐阳
 * @date：2020/5/5
 * @description:
 */
class MainViewModel : ViewModel() {

    private val newsApi = getRetrofit(null).create(NewsApi::class.java)
    private val lhbApi = getRetrofit(null).create(TestApi::class.java)

    private val _newsLiveData = MediatorLiveData<ResultData<HttpResultVo<List<DataDemo>>>>()
    private val _lhbLiveData = MediatorLiveData<ResultData<HttpResultVo<LongHuBangAdvisoryBean>>>()
    private val _allData = MediatorLiveData<ResultData<HttpResultVo<AllData>>>()

    // 对外暴露的只是抽象的LiveData，防止外部随意更改数据
    val newsLiveData: LiveData<ResultData<HttpResultVo<List<DataDemo>>>>
        get() = _newsLiveData
    val lhbLiveData: LiveData<ResultData<HttpResultVo<LongHuBangAdvisoryBean>>>
        get() = _lhbLiveData
    val allData: LiveData<ResultData<HttpResultVo<AllData>>>
        get() = _allData


    fun getNews() {
        val liveData = viewModelScope.simpleRequestLiveData<HttpResultVo<List<DataDemo>>> {
            api { newsApi.getNews() }
        }

        // 监听数据变化
        _newsLiveData.addSource(liveData)
    }

    fun getLhb() {
        val liveData = viewModelScope.simpleRequestLiveData<HttpResultVo<LongHuBangAdvisoryBean>> {
            api { lhbApi.getLhb() }
        }
        _lhbLiveData.addSource(liveData)
    }

    fun getAllData() {
        val liveData1 = viewModelScope.simpleRequestLiveData<HttpResultVo<AllData>> {
            api {
                withContext(Dispatchers.IO) {
                    val a1 = async { newsApi.getNews() }
                    val a2 = async { lhbApi.getLhb() }
                    val b1 = a1.await().result
                    val b2 = a2.await().result

                    val d = AllData(b2, b1)
                    val httpResultVo = HttpResultVo<AllData>()
                    httpResultVo.result = d
                    httpResultVo
                }

            }
        }

        _allData.addSource(liveData1)
    }
}