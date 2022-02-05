package com.midnight.android.movies.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.midnight.core.domain.MovieModelCore
import com.midnight.android.movies.R
import com.midnight.android.movies.databinding.ItemMovieBinding
import com.midnight.android.movies.interfaces.MovieClickDelegate
import com.midnight.android.movies.utils.DiffMovies
import kotlin.collections.ArrayList


class MoviesAdapter constructor(private val callBack: MovieClickDelegate): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var data: ArrayList<MovieModelCore> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binder: ItemMovieBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
        return ImageViewHolder(binder)

    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageViewHolder).bind(data[position], callBack)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty())
            super.onBindViewHolder(holder, position, payloads)
        else
            (holder as ImageViewHolder).bind(data[position], callBack)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ImageViewHolder(@NonNull private val binder: ItemMovieBinding) : RecyclerView.ViewHolder(binder.root) {

        fun bind(modeBook: MovieModelCore, delegate: MovieClickDelegate?) {
            binder.data = modeBook
            binder.delegate = delegate
            binder.executePendingBindings()
        }
    }

    public fun clear(){
        this.data.clear()
        notifyDataSetChanged()
    }

    public fun update(newData:List<MovieModelCore>){
        var dataOld:ArrayList<MovieModelCore> = ArrayList()
        dataOld.addAll(this.data)

        this.data.addAll(newData)
        val diffResult = DiffUtil.calculateDiff(DiffMovies(dataOld, this.data))
        diffResult.dispatchUpdatesTo(this)
    }


}