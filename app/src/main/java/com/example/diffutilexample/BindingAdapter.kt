package com.example.diffutilexample

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide

object BindingAdapter{

    @BindingAdapter("simple_diff_util_image_url")
    @JvmStatic
    fun setImageUrl(imageView: ImageView, imageUrl: String?){
        Log.i("url", imageUrl)
        Glide.with(imageView.context)
            .load(imageUrl)
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imageView)
    }
}

fun<T : ViewDataBinding?> ViewGroup.inflateLayout(layout: Int): T{
    return DataBindingUtil.inflate<T>(LayoutInflater.from(this.context), layout, this, false)
}