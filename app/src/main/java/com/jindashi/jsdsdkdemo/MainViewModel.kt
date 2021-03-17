package com.jindashi.jsdsdkdemo

import androidx.lifecycle.*
import com.jindashi.http.*
import com.jindashi.jsdsdkdemo.http.*
import com.jindashi.jsdsdkdemo.lhb.LongHuBangAdvisoryBean
import com.jindashi.jsdsdkdemo.lhb.TestApi

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

    // 对外暴露的只是抽象的LiveData，防止外部随意更改数据
    val newsLiveData: LiveData<ResultData<HttpResultVo<List<DataDemo>>>>
        get() = _newsLiveData
    val lhbLiveData: LiveData<ResultData<HttpResultVo<LongHuBangAdvisoryBean>>>
        get() = _lhbLiveData

    fun getNews() {
        val liveData = viewModelScope.simpleRequestLiveData<HttpResultVo<List<DataDemo>>> {
            api { newsApi.getNews() }

            /**
             * 以下内容为可选实现
             */

            // 加载数据库缓存，直接返回 room 数据库的 LiveData
//            loadCache {
//                return@loadCache roomLiveData
//            }

            // 保存数据到 room 数据库
//            saveCache {
//            }
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
}