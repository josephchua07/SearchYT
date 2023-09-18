package com.chua.searchyt.repository

import android.util.Log
import com.chua.searchyt.network.CommentResponse
import com.chua.searchyt.network.SearchResponse
import com.chua.searchyt.service.YoutubeService

class YoutubeRepositoryImpl(
    private val service: YoutubeService
) : YoutubeRepository {
    override suspend fun search(query: String, apiKey: String): SearchResponse {
        return try {
            val url =
                "https://www.googleapis.com/youtube/v3/search?part=snippet&q=$query&type=video&key=$apiKey"
            service.search(url)
        } catch (throwable: Throwable) {
            Log.d("SearchYT", throwable.message.toString())
            SearchResponse(emptyList())
        }
    }

    override suspend fun getComments(videoId: String, apiKey: String): CommentResponse {
        return try {
            val url =
                "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&key=${apiKey}&videoId=$videoId"
            service.getComments(url)
        } catch (throwable: Throwable) {
            Log.d("SearchYT", throwable.message.toString())
            CommentResponse(emptyList())
        }
    }
}