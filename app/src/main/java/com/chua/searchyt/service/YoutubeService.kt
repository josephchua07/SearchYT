package com.chua.searchyt.service

import com.chua.searchyt.network.CommentResponse
import com.chua.searchyt.network.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface YoutubeService {

    @GET
    suspend fun search(@Url url: String): SearchResponse

    @GET
    suspend fun getComments(@Url url: String): CommentResponse

}