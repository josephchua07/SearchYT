package com.chua.searchyt.repository

import com.chua.searchyt.network.SearchResponse

interface YoutubeRepository {

    suspend fun search(query: String, apiKey: String): SearchResponse

}