package com.jindashi.jsdsdkdemo.lhb

import com.jindashi.jsdsdkdemo.http.HttpResultVo
import retrofit2.http.GET

/**
 * @author: mlsnatalie
 * @date: 2021/3/12 4:15 PM
 * @UpdateDate: 2021/3/12 4:15 PM
 * email：mlsnatalie@163.com
 * description：
 */
interface TestApi {
    /**
     * 龙虎榜文章咨询接口
     * @return
     */
    @GET("/api/longhu/first")
    suspend fun getLhb(): HttpResultVo<LongHuBangAdvisoryBean>
}