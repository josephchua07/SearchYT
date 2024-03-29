package com.chua.searchyt.repository

import com.chua.searchyt.network.CommentResponse
import com.chua.searchyt.network.SearchResponse

interface YoutubeRepository {

    suspend fun search(query: String): SearchResponse

    suspend fun getComments(videoId: String): CommentResponse

}