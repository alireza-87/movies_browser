package com.midnight.android.movies.view

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.midnight.core.domain.DataState
import com.midnight.core.domain.MovieModelCore
import com.midnight.core.domain.NetworkErrorType
import com.midnight.android.movies.BuildConfig
import com.midnight.android.movies.R
import com.midnight.android.movies.databinding.FragmentMovieListBinding
import com.midnight.android.movies.interfaces.MovieClickDelegate
import com.midnight.android.movies.utils.Utilities
import com.midnight.android.movies.view.adapters.MoviesAdapter
import com.midnight.android.movies.viewmodels.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MovieListFragment: Fragment(),MovieClickDelegate {
    private val viewModel: MovieListViewModel  by viewModels()
    private lateinit var binder: FragmentMovieListBinding
    private lateinit var movieAdapter: MoviesAdapter
    private var errorDialog: Snackbar? = null
    private var lastPage:Int=1;
    private var listLayoutManager:GridLayoutManager ? = null
    private lateinit var listP:Parcelable
    private var savedData : ArrayList<MovieModelCore> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list,container,false);
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListView()
        initView()
        if (savedData.size>0)
            movieAdapter.update(savedData)
        else
            initData(1)
        initLiveData()

    }

    private fun initData(page:Int){
        viewModel.getMovies(BuildConfig.TMDB_API_KEY,Utilities.isNetworkAvailable(requireContext()),page,skip = movieAdapter.itemCount)
    }

    private fun initListView(){
        if (this::movieAdapter.isInitialized){
            savedData.addAll(movieAdapter.data)
        }
        movieAdapter = MoviesAdapter(this)
        binder.recyclerView.apply {
            listLayoutManager = GridLayoutManager(requireContext(), 3)
            layoutManager = listLayoutManager
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        binder.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (listLayoutManager?.findLastVisibleItemPosition()?.plus(3)?.compareTo(movieAdapter.itemCount)!! >0 && !isFetchOnGoing()){
                    initData(lastPage+1)
                }
            }
        })
    }

    private fun initLiveData(){
        viewModel.clearMoviesLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (!it.isHandled){
                when (val result =it.getContentIfNotHandled()) {
                    is DataState.Loading -> {
                        showLoading(isShow = true)
                    }
                    is DataState.Success -> {
                        showLoading(isShow = false)
                        //REST
                        //this.data.clear()
                        movieAdapter.clear()
                        lastPage=1
                        initData(lastPage)
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
            }
        })
        viewModel.itemLiveData.observe(viewLifecycleOwner,androidx.lifecycle.Observer{
            if (!it.isHandled){
                when (val result =it.getContentIfNotHandled()) {
                    is DataState.Loading -> {
                        showLoading(isShow = true)
                    }
                    is DataState.Success -> {
                        showLoading(isShow = false)
                        movieAdapter.update(result.value)
                        lastPage += 1
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
            }

        })
    }

    private fun initView(){
        binder.swipeRefreshLay.setOnRefreshListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(resources.getString(R.string.refresh_title))
                .setMessage(resources.getString(R.string.refresh_message))
                .setNeutralButton(resources.getString(R.string.no)) { dialog, _ ->
                    dialog.dismiss()
                }
                .setPositiveButton(resources.getString(R.string.yes)) { dialog, _ ->
                    dialog.dismiss()
                    viewModel.clearMovies()

                }
                .show()
            binder.swipeRefreshLay.isRefreshing = false
        }
    }

    private fun isFetchOnGoing():Boolean{
        return binder.progressBar.isVisible
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

    private fun showError(data: String) {
        binder.progressBar.visibility = View.GONE
        errorDialog = Snackbar.make(binder.root, data, Snackbar.LENGTH_LONG)
        errorDialog?.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


    override fun onClick(data: MovieModelCore) {
        findNavController().navigate(MovieListFragmentDirections.actionMovieListFragmentToDetailFragment(data.id))
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        errorDialog?.dismiss()
        binder.unbind()
    }

}