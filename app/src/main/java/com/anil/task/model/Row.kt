package com.anil.task.model

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.android.task.R
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Row {
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("description")

    @Expose
    var description: String? = null

  /*  @SerializedName("imageHref")
    @Expose
    var imageHref: Any? = null*/

    @SerializedName("imageHref")
    var imageHref: String? = null


    companion object {
        // important code for loading image here
        @BindingAdapter("imageHref")
        @JvmStatic
        fun loadImage(imageView: ImageView, imageURL: String?) {
            Log.e("@@Image@@",""+imageURL);
           /* Glide.with(imageView.context)
                    .setDefaultRequestOptions(RequestOptions()
                            .circleCrop())
                    .load(imageURL)
                    .placeholder(R.drawable.loading)
                    .into(imageView)*/

            try {
                var url =imageURL/* URL of Image */
                if (url != null) {
                    if (url.startsWith("http://")) url = url.replace("http://", "https://")
                }
                val requestOptions = RequestOptions()
                requestOptions.placeholder(R.drawable.loading)
                requestOptions.error(R.mipmap.ic_launcher)
                Glide
                        .with(imageView.context)
                        .setDefaultRequestOptions(requestOptions)
                        .load(url)
                        .into(imageView)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

}