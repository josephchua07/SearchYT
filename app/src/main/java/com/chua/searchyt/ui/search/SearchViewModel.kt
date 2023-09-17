package com.chua.searchyt.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    private val client = OkHttpClient()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            search("android developer")
        }
    }

    fun hello() {
        Log.d(TAG, "Hello")
    }

    fun search(query: String) {
        Log.d(TAG, query)

        val url =
            "https://www.googleapis.com/youtube/v3/search?part=snippet&q=$query&type=video&key=$myApiKey"

        val request = Request.Builder()
            .url(url)
            .build()

        val response = client.newCall(request).execute()
        val responseBody = response.body?.string()

        Log.d(TAG, responseBody.toString())
    }

    companion object {
        const val TAG = "ViewModel"
        const val myApiKey = "AIzaSyDugEdYdCuzBtgvV6oEV587u3Jb1tr1CFA"
    }
}