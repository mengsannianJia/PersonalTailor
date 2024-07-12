package com.smartlab411.personaltailor.activity

import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.smartlab411.personaltailor.BR
import com.smartlab411.personaltailor.R
import com.smartlab411.personaltailor.base.BaseActivity
import com.smartlab411.personaltailor.base.adapter.Pager2Adapter
import com.smartlab411.personaltailor.base.tab.NavigationBottomBar
import com.smartlab411.personaltailor.databinding.ActivityTabBinding
import com.smartlab411.personaltailor.databinding.FragmentKnowledgeBinding
import com.smartlab411.personaltailor.fragment.home.FragmentHome
import com.smartlab411.personaltailor.fragment.hot_key.FragmentHotKey
import com.smartlab411.personaltailor.fragment.knowledge.FragmentKnowledge
import com.smartlab411.personaltailor.fragment.personal.FragmentPersonal


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
class TabActivity : BaseActivity<ActivityTabBinding, TabViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_tab
    }

    override fun getViewModelId(): Int {
        return BR.tabVM
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initViewData() {
        // 设置状态栏颜色
        window.apply {
            // 使状态栏背景半透明
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            // 设置状态栏背景颜色
            statusBarColor = ContextCompat.getColor(this@TabActivity, R.color.status_bar_theme)
            // 设置状态栏字体颜色为黑色
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                insetsController?.setSystemBarsAppearance(
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
            } else {
                @Suppress("DEPRECATION")
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }

        // 初始化ViewPager2
        initPages()

        // tab中被选中的图标
        val selectedIcons = arrayOf(
            BitmapFactory.decodeResource(resources, R.drawable.icon_home_selected),
            BitmapFactory.decodeResource(resources, R.drawable.icon_hot_key_selected),
            BitmapFactory.decodeResource(resources, R.drawable.icon_knowledge_selected),
            BitmapFactory.decodeResource(resources, R.drawable.icon_personal_selected),
        )
        // tab中未被选中的图标
        val unSelectedIcons = arrayOf(
            BitmapFactory.decodeResource(resources, R.drawable.icon_home_grey),
            BitmapFactory.decodeResource(resources, R.drawable.icon_hot_key_grey),
            BitmapFactory.decodeResource(resources, R.drawable.icon_knowledge_grey),
            BitmapFactory.decodeResource(resources, R.drawable.icon_personal_grey),
        )
        // tab中按钮对应的title
        val tabTexts = arrayOf("首页", "热点", "体系", "个人")

        binding?.tabBottomBar?.setSelectedIcons(selectedIcons.toList())
        binding?.tabBottomBar?.setUnselectIcons(unSelectedIcons.toList())
        binding?.tabBottomBar?.setTabText(tabTexts.toList())
        binding?.tabBottomBar?.setupViewpager(binding?.tabViewPage2)
        binding?.tabBottomBar?.start()

        // tab点击回调
        binding?.tabBottomBar?.registerTabClickListener(object : NavigationBottomBar.OnBottomTabClickListener{
            override fun tabClick(position: Int) {
                Log.d("tab切换","tabBottomBar ---- 点击事件触发 切换到${tabTexts[position]}页面")
            }
        })
    }

    /**
     * TODO 初始化ViewPage2
     *
     */
    private fun initPages(){
        val tabPages = mutableListOf<Fragment>()
        tabPages.add(FragmentHome())
        tabPages.add(FragmentHotKey())
        tabPages.add(FragmentKnowledge())
        tabPages.add(FragmentPersonal())

        val pager2Adapter = Pager2Adapter(this)
        pager2Adapter.setData(tabPages)

        // 视图数据绑定
        binding?.tabViewPage2?.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
        binding?.tabViewPage2?.adapter = pager2Adapter
    }
}

