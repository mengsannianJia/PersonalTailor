package com.smartlab411.personaltailor.fragment.hot_key

import com.smartlab411.personaltailor.R
import com.smartlab411.personaltailor.BR
import com.smartlab411.personaltailor.base.BaseFragment
import com.smartlab411.personaltailor.databinding.FragmentHotKeyBinding

/**
 *
 * @ProjectName:    PersonalTailor
 * @Package:        com.smartlab411.personaltailor.fragment.hot_key
 * @ClassName:      FragmentHotKey
 * @Description:     java类作用描述
 * @Author:         jiajiangshan
 * @CreateDate:     2024/7/4 17:12
 * @UpdateUser:     更新者：
 * @UpdateDate:     2024/7/4 17:12
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class FragmentHotKey : BaseFragment<FragmentHotKeyBinding, FragmentHotKeyViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_hot_key
    }

    override fun getViewModelId(): Int {
        return BR.hotKeyVM
    }

    override fun initViewData() {

    }
}