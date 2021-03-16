package com.jindashi.jsdsdkdemo.http

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * 自定义标准接口json返回格式类
 * 该类需要根据每个公司具体的接口规范文档而定
 *
 * @author zhang.zheng
 * @version 2017-11-22
 */
class HttpResultVo1<T> : Serializable {
    // 返回码
    @SerializedName(value = "code", alternate = ["Code"])
    var code = 0

    // 提示信息
    @SerializedName(value = "message", alternate = ["Msg"])
    var message: String? = null

    // 数据
    @SerializedName(value = "result", alternate = ["Data", "data"])
    var data: T? = null
        private set
    get()
    {
        return field
    }
//    set

    fun setResult(result: T) {
        data = result
    }

}