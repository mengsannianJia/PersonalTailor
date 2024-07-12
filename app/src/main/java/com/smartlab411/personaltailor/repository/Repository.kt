package com.smartlab411.personaltailor.repository

import com.smartlab411.personaltailor.android.http.RetrofitClient
import com.smartlab411.personaltailor.repository.entity.HomeListData

/**
 *
 * @ProjectName:    PersonalTailor
 * @Package:        com.smartlab411.personaltailor.repository
 * @ClassName:      Repository
 * @Description:    ApiService 接口实现单例
 * @Author:         jiajiangshan
 * @CreateDate:     2024/7/5 13:51
 * @UpdateUser:     更新者：
 * @UpdateDate:     2024/7/5 13:51
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
object Repository {

    /**
     * TODO 获取首页数据
     *
     * @param pageCount
     * @return
     */
    suspend fun getHomeList(pageCount:String) : HomeListData?{
        val data = RetrofitClient.getInstance().getDefault(ApiService :: class.java).getHomeList(pageCount)
        if(data?.getData() != null)
            return data.getData()
        return null
    }
}