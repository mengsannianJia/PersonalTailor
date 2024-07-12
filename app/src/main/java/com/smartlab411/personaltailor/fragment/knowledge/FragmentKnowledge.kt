package com.smartlab411.personaltailor.fragment.knowledge

import com.smartlab411.personaltailor.R
import com.smartlab411.personaltailor.BR
import com.smartlab411.personaltailor.base.BaseFragment
import com.smartlab411.personaltailor.databinding.FragmentKnowledgeBinding

/**
 *
 * @ProjectName:    PersonalTailor
 * @Package:        com.smartlab411.personaltailor.fragment.knowledge
 * @ClassName:      FragmentKnowledge
 * @Description:     java类作用描述
 * @Author:         jiajiangshan
 * @CreateDate:     2024/7/4 17:14
 * @UpdateUser:     更新者：
 * @UpdateDate:     2024/7/4 17:14
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class FragmentKnowledge : BaseFragment<FragmentKnowledgeBinding, FragmentKnowledgeViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_knowledge
    }

    override fun getViewModelId(): Int {
        return BR.knowledgeVM
    }

    override fun initViewData() {

    }
}