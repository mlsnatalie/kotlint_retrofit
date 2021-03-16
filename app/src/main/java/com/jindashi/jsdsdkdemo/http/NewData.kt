package com.jindashi.jsdsdkdemo.http

/**
 * @author: mlsnatalie
 * @date: 2021/3/16 7:13 PM
 * @UpdateDate: 2021/3/16 7:13 PM
 * email：mlsnatalie@163.com
 * description：
 */
data class NewData(
    val code: Int,
    val message: String,
    val result: List<Result>
)

data class Result(
    val image: String,
    val passtime: String,
    val path: String,
    val title: String
)