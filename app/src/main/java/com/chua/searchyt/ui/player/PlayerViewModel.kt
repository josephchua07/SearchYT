package com.chua.searchyt.ui.player

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor() : ViewModel() {

    init {
        Log.d(TAG, "player")
    }
    companion object {
        const val TAG = "SearchYT"
        const val myApiKey = "AIzaSyDugEdYdCuzBtgvV6oEV587u3Jb1tr1CFA"
    }

}