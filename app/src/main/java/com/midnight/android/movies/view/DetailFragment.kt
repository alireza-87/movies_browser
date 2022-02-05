package com.midnight.android.movies.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.midnight.core.domain.DataState
import com.midnight.core.domain.DetailModelCore
import com.midnight.core.domain.NetworkErrorType
import com.midnight.android.movies.BuildConfig
import com.midnight.android.movies.R
import com.midnight.android.movies.databinding.FragmentDetailBinding
import com.midnight.android.movies.utils.Utilities
import com.midnight.android.movies.viewmodels.DetailViewModel
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.midnight.android.movies.utils.constants
import dagger.hilt.android.AndroidEntryPoint
import android.graphics.Typeface
import android.text.style.StyleSpan


@AndroidEntryPoint
class DetailFragment: Fragment() {
    private val viewModel: DetailViewModel by viewModels()

    private lateinit var binder: FragmentDetailBinding
    private var errorDialog: Snackbar? = null
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_detail,container,false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData(args?.movieId)
        initLiveData()
    }

    private fun initData(id:Int){
        viewModel.getDetail(BuildConfig.TMDB_API_KEY,Utilities.isNetworkAvailable(requireContext()),id)
    }

    private fun initView(it:DetailModelCore){
        val url = "${constants.IMAGE_URL}t/p/w500${it.backdropPath}"
        binder.ratingBar.visibility =View.VISIBLE
        binder.ratingBar.rating = Utilities.convertRate(it.voteAverage!!,10,5)
        binder.textViewTitle.text = it.title
        binder.textViewAvrVote.text = ""
        binder.textViewAvrVote.append(string = it.voteAverage.toString(),color = R.color.colorAccent,bold = true)
        binder.textViewAvrVote.append(" /10", R.color.black)

        binder.textViewDetail.text = it.overview
        binder.textViewGener.text = it.genres?.get(0)?.name
        binder.textViewReleaseData.text = it.releaseDate
        binder.textViewRunTime.text = it.runtime?.toString()+" ${getString(R.string.minute)}"
        Glide.with(requireContext())
            .load(url)
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_placeholder)
            .listener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any,
                    target: com.bumptech.glide.request.target.Target<Drawable?>,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any,
                    target: com.bumptech.glide.request.target.Target<Drawable?>,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }
            })
            .into(binder.imageViewMain)

    }

    private fun showLoading(isShow:Boolean){
        when (isShow){
            true ->{
                binder.progressBar.visibility = View.VISIBLE
            }
            false ->{
                binder.progressBar.visibility = View.GONE
            }
        }
    }

    private fun initLiveData(){
        viewModel.itemLiveData.observe(viewLifecycleOwner,androidx.lifecycle.Observer{
            val result =it.getContentIfNotHandled()
            when (result) {
                is DataState.Loading -> {
                    showLoading(isShow = true)
                }
                is DataState.Success -> {
                    showLoading(isShow = false)
                    initView(result.value)
                }
                is DataState.LocalError -> {
                    showError(
                        data = result.message ?: Utilities.getString(
                            requireContext(),
                            R.string.local_error
                        )
                    )
                }
                is DataState.NetworkError -> {
                    when (result.networkError) {
                        is NetworkErrorType.NetworkConnection -> {
                            showError(
                                data = Utilities.getString(
                                    requireContext(),
                                    R.string.no_internet
                                )
                            )
                        }
                        is NetworkErrorType.Unknown -> {
                            showError(
                                data = Utilities.getString(
                                    requireContext(),
                                    R.string.error_unknow
                                ))
                        }
                        else -> {
                            showError(
                                data = Utilities.getString(
                                    requireContext(),
                                    R.string.error_serverfail
                                ))
                        }
                    }

                }
            }
        })
    }

    private fun showError(data: String) {
        binder.progressBar.visibility = View.GONE
        errorDialog = Snackbar.make(binder.root, data, Snackbar.LENGTH_LONG)
        errorDialog?.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        errorDialog?.dismiss()
        binder.unbind()
    }

    fun TextView.append(string: String?, @ColorRes color: Int,bold:Boolean=false) {
        if (string == null || string.isEmpty()) {
            return
        }

        val spannable: Spannable = SpannableString(string)
        spannable.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, color)),
            0,
            spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        if (bold)
            spannable.setSpan(
                StyleSpan(Typeface.BOLD),
                0,
                spannable.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

        append(spannable)
    }

    override fun onDestroy() {
        super.onDestroy()
        errorDialog?.dismiss()
        Glide.with(this).clear(binder.imageViewMain)
        binder.unbind()
    }

}