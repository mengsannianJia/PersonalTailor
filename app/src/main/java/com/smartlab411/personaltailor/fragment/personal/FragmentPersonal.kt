package com.smartlab411.personaltailor.fragment.personal

import com.smartlab411.personaltailor.R
import com.smartlab411.personaltailor.BR
import com.smartlab411.personaltailor.base.BaseFragment
import com.smartlab411.personaltailor.databinding.FragmentPersonalBinding

/**
 *
 * @ProjectName:    PersonalTailor
 * @Package:        com.smartlab411.personaltailor.fragment.personal
 * @ClassName:      FragmentPersonal
 * @Description:     java类作用描述
 * @Author:         jiajiangshan
 * @CreateDate:     2024/7/4 17:14
 * @UpdateUser:     更新者：
 * @UpdateDate:     2024/7/4 17:14
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class FragmentPersonal : BaseFragment<FragmentPersonalBinding, FragmentPersonalViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_personal
    }

    override fun getViewModelId(): Int {
        return BR.personalVM
    }

    override fun initViewData() {

    }
}