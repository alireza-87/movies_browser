package com.midnight.android.movies.view.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.midnight.core.domain.MovieModelCore
import com.midnight.android.movies.R
import com.midnight.android.movies.utils.constants

@BindingAdapter("app:moviePoster")
fun moviePoster(view: ImageView, item:MovieModelCore) {
    item?.let {
        val url = "${constants.IMAGE_URL}t/p/w500${item.posterPath}"
        Glide.with(view.context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .transform(RoundedCorners(25))
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.ic_placeholder)
            .into(view)
    }
}
