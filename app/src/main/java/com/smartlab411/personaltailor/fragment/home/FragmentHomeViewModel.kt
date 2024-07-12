package com.smartlab411.personaltailor.fragment.home

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.smartlab411.personaltailor.base.BaseViewModel
import com.smartlab411.personaltailor.base.SingleLiveEvent
import com.smartlab411.personaltailor.repository.Repository
import com.smartlab411.personaltailor.repository.entity.HomeListItemData
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *
 * @ProjectName:    PersonalTailor
 * @Package:        com.smartlab411.personaltailor.fragment
 * @ClassName:      FragmentHomeViewModel
 * @Description:     java类作用描述
 * @Author:         jiajiangshan
 * @CreateDate:     2024/7/4 12:44
 * @UpdateUser:     更新者：
 * @UpdateDate:     2024/7/4 12:44
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class FragmentHomeViewModel(application : Application) : BaseViewModel(application) {

    val list = SingleLiveEvent<List<HomeListItemData>?>()
    init {
        getHomeList()
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun getHomeList(){
        /**
         * 方法一：GlobalScope协程
         */
        // 使用 GlobalScope 启动协程 Dispatchers.Main
        // GlobalScope.launch(Dispatchers.IO){
        //    Repository.getHomeList("0");
        // }

        // getHomeList 被关键字 suspend 修饰，只能在协程中被调用
        // Repository.getHomeList("0");


        /**
         * 方法二：viewModelScope协程
         */
        viewModelScope.launch(Dispatchers.IO) {
            val data = Repository.getHomeList("0")
            if(data != null){
                list.postValue(data.datas)
            }
        }
    }

}