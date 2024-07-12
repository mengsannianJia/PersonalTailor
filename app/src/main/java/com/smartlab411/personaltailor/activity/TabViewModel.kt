package com.smartlab411.personaltailor.activity

import android.app.Application
import androidx.databinding.ObservableField
import com.smartlab411.personaltailor.base.BaseViewModel

/**
 *
 * @ProjectName:    PersonalTailor
 * @Package:        com.smartlab411.personaltailor
 * @ClassName:      TabViewModel
 * @Description:     java类作用描述
 * @Author:         jiajiangshan
 * @CreateDate:     2024/7/1 14:28
 * @UpdateUser:     更新者：
 * @UpdateDate:     2024/7/1 14:28
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class TabViewModel(application : Application) : BaseViewModel(application){

    var text = ObservableField<String>()
}