package com.jindashi.jsdsdkdemo.http

/**
 *   @auther : Aleyn
 *   time   : 2019/11/01
 */
data class BaseResult<T>(
    val message: String,
    val code: Int,
    val result: T
)