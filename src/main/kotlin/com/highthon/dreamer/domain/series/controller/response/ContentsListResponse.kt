package com.highthon.dreamer.domain.series.controller.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.util.UUID

data class ContentsListResponse (

    @JsonProperty("Title")
    val title: String,
    @JsonProperty("CreatedAt")
    val createdAt: LocalDateTime,
    @JsonProperty("ReplyCount")
    val replyCount: Int,
    @JsonProperty("WritedBy")
    val writedBy: String,
    @JsonProperty("WritedById")
    val writedById: UUID,
)