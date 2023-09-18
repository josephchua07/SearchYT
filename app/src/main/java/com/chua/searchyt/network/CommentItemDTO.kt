package com.chua.searchyt.network

data class CommentItemDTO(
    val kind: String,
    val etag: String,
    val id: String,
    val snippet: CommentItemSnippet
)

data class CommentItemSnippet(
    val videoId: String,
    val topLevelComment: CommentItemSnippetTopLevelComment,
    val canReply: Boolean,
    val totalReplyCount: Int,
    val isPublic: Boolean
)

data class CommentItemSnippetTopLevelComment(
    val snippet: CommentItemSnippetTopLevelCommentSnippet
)

data class CommentItemSnippetTopLevelCommentSnippet(
    val textOriginal: String,
    val authorDisplayName: String
)