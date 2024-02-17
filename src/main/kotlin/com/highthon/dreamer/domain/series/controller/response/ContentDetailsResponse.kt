package com.highthon.dreamer.domain.series.controller.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.querydsl.core.annotations.QueryProjection
import java.util.*

data class ContentDetailsResponse
@QueryProjection constructor (
    @JsonProperty("ContentId")
    val contentId: Long,
    @JsonProperty("Title")
    val title: String,
    @JsonProperty("SeriesTitle")
    val seriesTitle: String,
    @JsonProperty("Number")
    val number: Long,
    @JsonProperty("Description")
    val description: String,
    @JsonProperty("CreatedBy")
    val createdBy: User,
    @JsonProperty("Replies")
    var replies: List<Reply>?
) {
    companion object {
        class User
        @QueryProjection constructor (
            @JsonProperty("UserId")
            val userId: UUID,
            @JsonProperty("Profile")
            val profile: String,
            @JsonProperty("Name")
            val name: String,
            @JsonProperty("Email")
            val email: String,
            @JsonProperty("Introduce")
            val introduce: String,
        )

        class Reply
        @QueryProjection constructor (
            @JsonProperty("ReplyId")
            val replyId: Long,
            @JsonProperty("UserName")
            val userName: String,
            @JsonProperty("Content")
            val content: String,
            @JsonProperty("UserId")
            val userId: UUID
        )
    }
}
