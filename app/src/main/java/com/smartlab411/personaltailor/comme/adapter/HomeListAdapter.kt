package com.smartlab411.personaltailor.comme.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.smartlab411.personaltailor.R
import com.smartlab411.personaltailor.databinding.ItemHomeListBinding
import com.smartlab411.personaltailor.repository.entity.HomeListItemData

/**
 *
 * @ProjectName:    PersonalTailor
 * @Package:        com.smartlab411.personaltailor.comme.adapter
 * @ClassName:      HomeList适配器 控制HomeList数据
 * @Description:     HomeList
 * @Author:         jiajiangshan
 * @CreateDate:     2024/7/11 18:15
 * @UpdateUser:     更新者：
 * @UpdateDate:     2024/7/11 18:15
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class HomeListAdapter: RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {

    private var homeListItemData: List<HomeListItemData> = mutableListOf()

    class HomeListViewHolder(binding: ItemHomeListBinding):RecyclerView.ViewHolder(binding.root){
        var itemBinding:ItemHomeListBinding
        init {
            itemBinding = binding
        }
    }

    fun setData(list: List<HomeListItemData>){
        if(list.isNotEmpty()){
            homeListItemData = list
            notifyDataSetChanged()
        }
    }

    /**
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        return HomeListViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_home_list, parent, false))
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return homeListItemData.size
    }

    /**
     *
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        // 通过 holder 获取 view对象
        val item = homeListItemData[position]

        holder.itemBinding.itemVM = item

        // 设置收藏按钮状态////
        if(item.collect!!)
            holder.itemBinding.homeItemCollectBtn.setBackgroundResource(R.drawable.img_collect)
        else
            holder.itemBinding.homeItemCollectBtn.setBackgroundResource(R.drawable.img_collect_grey)

    }
}