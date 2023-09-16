package com.chua.searchyt.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    fun hello() {
        Log.d("ViewModel","Hello")
    }

}