package com.example.diffutilexample.view_life_cycle_aware

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import com.example.diffutilexample.CustomModel
import com.example.diffutilexample.R
import com.example.diffutilexample.adapter.CoreDiffUtilAdapter
import com.example.diffutilexample.databinding.SimpleDiffUtilLifeCycleAwareItemLayoutBinding
import com.example.diffutilexample.inflateLayout
import com.example.diffutilexample.lifecycleraware.LifeCycleViewHolder

class SimpleDiffUtilWithLifeCycleAwareAdapter(val listener: ViewClick ?= null) :
    CoreDiffUtilAdapter<SimpleDiffUtilWithLifeCycleAwareAdapter.ViewHolder, CustomModel>(CALL_BACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ItemViewHolder(parent.inflateLayout(R.layout.diff_util_life_cycle_aware_item_layout))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    inner class ItemViewHolder(private val binding: SimpleDiffUtilLifeCycleAwareItemLayoutBinding): ViewHolder(binding.root){

        init {
            binding.ivIconFav.setOnClickListener{
                listener?.onFavButtonClick()?.observe(this, Observer {
                    binding.iconColor = Color.RED
                    binding.executePendingBindings()
                })
            }
        }

        override fun bindItem(item: CustomModel?) = item?.let {
            binding.imageUrl = item.url
            binding.title = item.title
            binding.message = item.msg
            binding.iconColor = Color.GRAY

            binding.executePendingBindings()
        } ?: kotlin.run {
            binding.unbind()
        }

    }

    abstract class ViewHolder(val view: View): LifeCycleViewHolder(view){
        abstract fun bindItem(item: CustomModel?)
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.onAppear()
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.onDisappear()
    }


    companion object {
        val CALL_BACK= object : DiffUtil.ItemCallback<CustomModel>(){
            override fun areItemsTheSame(oldItem: CustomModel, newItem: CustomModel): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: CustomModel, newItem: CustomModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    interface ViewClick{
        fun onFavButtonClick(): LiveData<Boolean>
    }
}