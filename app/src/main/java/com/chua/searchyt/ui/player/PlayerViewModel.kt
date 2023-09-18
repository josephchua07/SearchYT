package com.chua.searchyt.ui.player

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chua.searchyt.network.CommentResponse
import com.chua.searchyt.repository.YoutubeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val youtubeRepository: YoutubeRepository
) : ViewModel() {

    private val _commentResponse = MutableLiveData<CommentResponse>()
    val commentResponse: LiveData<CommentResponse>
        get() = _commentResponse

    fun getComments(videoId: String) {
        Log.d(TAG, videoId)
        viewModelScope.launch {
            val response: CommentResponse = youtubeRepository.getComments(videoId, myApiKey)
            for (item in response.items) {
                Log.d(TAG, item.snippet.topLevelComment.snippet.authorDisplayName)
                Log.d(TAG, item.snippet.topLevelComment.snippet.textOriginal)
            }
            _commentResponse.postValue(response)
        }
    }

    companion object {
        const val TAG = "SearchYT"
        const val myApiKey = "AIzaSyDugEdYdCuzBtgvV6oEV587u3Jb1tr1CFA"
    }

}