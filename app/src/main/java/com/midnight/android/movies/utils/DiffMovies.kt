package com.midnight.android.movies.utils

import androidx.recyclerview.widget.DiffUtil
import com.midnight.core.domain.MovieModelCore

class DiffMovies constructor(private val oldItems: List<MovieModelCore>, private  val newItems: List<MovieModelCore>): DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].compareTo(newItems[newItemPosition])==1
    }


}