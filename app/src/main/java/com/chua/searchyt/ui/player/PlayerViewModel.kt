package com.chua.searchyt.ui.player

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
        viewModelScope.launch {
            val response: CommentResponse = youtubeRepository.getComments(videoId)
            _commentResponse.postValue(response)
        }
    }

}