package com.smartlab411.personaltailor.repository

import com.smartlab411.personaltailor.android.http.ApiAddress.Article_List
import com.smartlab411.personaltailor.android.http.BaseResponse
import com.smartlab411.personaltailor.repository.entity.HomeListData
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * @ProjectName:    PersonalTailor
 * @Package:        com.smartlab411.personaltailor.repository
 * @ClassName:      ApiService
 * @Description:    请求Api接口定义
 * @Author:         jiajiangshan
 * @CreateDate:     2024/7/5 13:37
 * @UpdateUser:     更新者：
 * @UpdateDate:     2024/7/5 13:37
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
interface ApiService {

    /**
     * TODO 获取主页列表数据
     * @param pageCount 获取数据页数  (0页起)
     */
    @GET("$Article_List{pageCount}/json")
    suspend fun getHomeList(@Path("pageCount") pageCount:String):BaseResponse<HomeListData>?


}