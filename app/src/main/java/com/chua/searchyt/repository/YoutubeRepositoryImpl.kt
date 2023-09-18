package com.chua.searchyt.repository

import android.util.Log
import com.chua.searchyt.network.SearchResponse
import com.chua.searchyt.service.YoutubeService

class YoutubeRepositoryImpl(
    private val service: YoutubeService
) : YoutubeRepository {
    override suspend fun search(query: String, apiKey: String): SearchResponse {
        return try {
            Log.d("SearchYT", "repository")
            Log.d("SearchYT", "search")
            Log.d("SearchYT", query)
            Log.d("SearchYT", apiKey)
            val url = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=$query&type=video&key=$apiKey"
            service.search(url)
        } catch (throwable: Throwable) {
            Log.d("SearchYT", throwable.message.toString())
            SearchResponse(emptyList())
        }
    }
}