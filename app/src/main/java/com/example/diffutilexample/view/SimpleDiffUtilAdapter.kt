package com.example.diffutilexample.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilexample.CustomModel
import com.example.diffutilexample.R
import com.example.diffutilexample.adapter.CoreDiffUtilAdapter
import com.example.diffutilexample.databinding.SimpleDiffUtilItemLayoutBinding
import com.example.diffutilexample.inflateLayout

class SimpleDiffUtilAdapter: CoreDiffUtilAdapter<SimpleDiffUtilAdapter.ViewHolder, CustomModel>(CALL_BACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ItemViewHolder(parent.inflateLayout(R.layout.simple_diff_util_item_layout))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    inner class ItemViewHolder(private val binding: SimpleDiffUtilItemLayoutBinding): ViewHolder(binding.root){
        override fun bindItem(item: CustomModel?) = item?.let {
            binding.imageUrl = item.url
            binding.title = item.title
            binding.message = item.msg

            binding.executePendingBindings()
        } ?: kotlin.run {
            binding.unbind()
        }

    }

    abstract class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        abstract fun bindItem(item: CustomModel?)
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
}