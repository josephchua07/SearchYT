package com.chua.searchyt.network

data class SearchItemDTO(
    val kind: String,
    val etag: String,
    val id: SearchItemId,
    val snippet: SearchItemSnippet
)

data class SearchItemId(
    val kind: String,
    val videoId: String,
)

data class SearchItemSnippet(
    val publishedAt: String,
    val channelId: String,
    val title: String,
    val description: String,
    val thumbnails: SearchItemSnippetThumbnails,
    val channelTitle: String,
    val liveBroadcastContent: String,
    val publishTime: String
)

data class SearchItemSnippetThumbnails(
    val default: Thumbnail,
    val medium: Thumbnail,
    val high: Thumbnail
)

data class Thumbnail(
    val url: String,
    val width: Int,
    val height: Int,
)

