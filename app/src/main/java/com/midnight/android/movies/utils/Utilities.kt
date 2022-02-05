package com.midnight.android.movies.utils

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build


class Utilities {
    companion object{
        fun convertRate(rate:Float,currentGrade:Int,expectGrade:Int):Float{
            return rate*expectGrade/currentGrade
        }

        fun isNetworkAvailable(context: Context): Boolean {
            if (context == null) return false
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    return true
                }
            } else {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                    return true
                }
            }
            return false
        }

        fun getString(context: Context, resourceId: Int): String {
            return context.resources.getString(resourceId)
        }


    }
}