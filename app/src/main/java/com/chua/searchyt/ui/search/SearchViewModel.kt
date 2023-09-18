package com.chua.searchyt.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chua.searchyt.network.SearchResponse
import com.chua.searchyt.repository.YoutubeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val youtubeRepository: YoutubeRepository
) : ViewModel() {

    private val _searchResponse = MutableLiveData<SearchResponse>()
    val searchResponse: LiveData<SearchResponse>
        get() = _searchResponse

    fun search(query: String) {
        viewModelScope.launch {
            val response: SearchResponse = youtubeRepository.search(query)
            _searchResponse.postValue(response)
        }
    }
}