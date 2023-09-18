package com.chua.searchyt.repository

import android.util.Log
import com.chua.searchyt.network.CommentResponse
import com.chua.searchyt.network.SearchResponse
import com.chua.searchyt.service.YoutubeService

class YoutubeRepositoryImpl(
    private val service: YoutubeService
) : YoutubeRepository {
    override suspend fun search(query: String): SearchResponse {
        return try {
            val url =
                "${BASE_URL}search?part=snippet&q=$query&type=video&key=$API_KEY"
            service.search(url)
        } catch (throwable: Throwable) {
            Log.d("SearchYT", throwable.message.toString())
            SearchResponse(emptyList())
        }
    }

    override suspend fun getComments(videoId: String): CommentResponse {
        return try {
            val url =
                "${BASE_URL}commentThreads?part=snippet&key=${API_KEY}&videoId=$videoId"
            service.getComments(url)
        } catch (throwable: Throwable) {
            Log.d("SearchYT", throwable.message.toString())
            CommentResponse(emptyList())
        }
    }

    companion object {
        const val BASE_URL = "https://www.googleapis.com/youtube/v3/"
        const val API_KEY = "AIzaSyDugEdYdCuzBtgvV6oEV587u3Jb1tr1CFA"
    }
}