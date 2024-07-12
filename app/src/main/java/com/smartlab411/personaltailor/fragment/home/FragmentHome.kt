package com.smartlab411.personaltailor.fragment.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.TelephonyManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartlab411.personaltailor.BR
import com.smartlab411.personaltailor.R
import com.smartlab411.personaltailor.base.BaseFragment
import com.smartlab411.personaltailor.comme.adapter.HomeListAdapter
import com.smartlab411.personaltailor.databinding.FragmentHomeBinding


/**
 *
 * @ProjectName:    PersonalTailor
 * @Package:        com.smartlab411.personaltailor.fragment
 * @ClassName:      FragmentHome
 * @Description:     java类作用描述
 * @Author:         jiajiangshan
 * @CreateDate:     2024/7/4 12:15
 * @UpdateUser:     更新者：
 * @UpdateDate:     2024/7/4 12:15
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */




class FragmentHome : BaseFragment<FragmentHomeBinding, FragmentHomeViewModel>() {

    private val adapter = HomeListAdapter()
    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun getViewModelId(): Int {
        return BR.homeVM
    }

    override fun initViewData() {
        // 获取首页数据
        binding?.homeListView?.layoutManager = LinearLayoutManager(context)
        binding?.homeListView?.adapter = adapter

        viewModel?.list?.observe(viewLifecycleOwner){list ->
            if (list != null) {
                adapter.setData(list)
            }
        }
    }

}
