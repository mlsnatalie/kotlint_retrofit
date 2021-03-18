package com.jindashi.jsdsdkdemo.lhb

import com.jindashi.jsdsdkdemo.http.DataDemo
import java.io.Serializable

/**
 * @author: mlsnatalie
 * @date: 2021/3/18 10:49 AM
 * @UpdateDate: 2021/3/18 10:49 AM
 * email：mlsnatalie@163.com
 * description：
 */
data class AllData(
        val data1: List<DataDemo>,
        val data2: LongHuBangAdvisoryBean

)