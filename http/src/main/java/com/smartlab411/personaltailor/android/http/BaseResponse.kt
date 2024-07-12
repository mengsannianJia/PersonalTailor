package com.smartlab411.personaltailor.android.http

import java.io.Serializable

/**
 * 通用的响应封装类
 * TODO 处理从服务器返回的数据
 *
 * @param T 泛型 T 适应不同类型的响应数据
 */

class BaseResponse<T> : Serializable {

    // 错误信息
    private var errorMsg: String? = null
    // 错误代码
    // errorCode = 0 代表执行成功，不建议依赖任何非0的 errorCode.
    // errorCode = -1001 代表登录失效，需要重新登录。
    private var errorCode: Int? = null
    // 实际响应数据的泛型变量 T
    private var data: T? = null


    fun getErrMsg(): String? {
        return errorMsg
    }

    fun setErrMsg(message: String?) {
        this.errorMsg = message
    }

    fun getData(): T? {
        return data
    }

    fun setData(data: T) {
        this.data = data
    }

    fun getErrCode(): Int? {
        return errorCode
    }

    fun setErrCode(errCode: Int?) {
        this.errorCode = errCode
    }
}

