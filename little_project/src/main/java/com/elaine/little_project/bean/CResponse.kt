package com.elaine.little_project.bean

import com.google.gson.annotations.SerializedName

/**
 * 通用网络请求
 */
data class CResponse<T>(
    @SerializedName("showapi_res_error")
    val msg: String,//错误提示
    @SerializedName("showapi_res_code")
    val code: Int,//错误码
    @SerializedName("showapi_res_body")
    val data: T//数据
)