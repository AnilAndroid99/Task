package com.anil.task.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.android.task.R
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Employee {
    @SerializedName("avatar")
    var avatar: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("description")

    @Expose
    var description: String? = null

    companion object {
        // important code for loading image here
        @BindingAdapter("avatar")
        fun loadImage(imageView: ImageView, imageURL: String?) {
            Glide.with(imageView.context)
                    .setDefaultRequestOptions(RequestOptions()
                            .circleCrop())
                    .load(imageURL)
                    .placeholder(R.drawable.loading)
                    .into(imageView)
        }
    }
}