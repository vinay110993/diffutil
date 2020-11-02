package com.example.diffutilexample.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class CoreDiffUtilAdapter<T : RecyclerView.ViewHolder, U>(private val diffItemCallBack: DiffUtil.ItemCallback<U>) :
    RecyclerView.Adapter<T>() {

    private var mItems: List<U> ?= null

    fun updateItems(item: List<U>?){
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback(){
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldListItem: U = mItems?.getOrNull(oldItemPosition) ?: return false
                val newListItem: U = item?.getOrNull(newItemPosition) ?: return false
                return diffItemCallBack.areItemsTheSame(oldListItem, newListItem)
            }
            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldListItem: U = mItems?.getOrNull(oldItemPosition) ?: return false
                val newListItem: U = item?.getOrNull(newItemPosition) ?: return false
                return diffItemCallBack.areContentsTheSame(oldListItem, newListItem)
            }
            override fun getOldListSize()= mItems?.size ?: 0
            override fun getNewListSize(): Int  = item?.size ?: 0
        })
        this.mItems = item
        diffResult.dispatchUpdatesTo(this)
    }
    fun getItem(pos: Int) = mItems?.getOrNull(pos)
    override fun getItemCount()= mItems?.size ?: 0

}