package com.midnight.android.movies.interfaces

import com.midnight.core.domain.MovieModelCore

interface MovieClickDelegate {
    public fun onClick(data:MovieModelCore)
}