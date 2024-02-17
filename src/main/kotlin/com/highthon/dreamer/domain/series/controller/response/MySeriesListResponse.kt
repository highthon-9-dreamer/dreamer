package com.highthon.dreamer.domain.series.controller.response

import com.fasterxml.jackson.annotation.JsonProperty

data class MySeriesListResponse (
    @JsonProperty("SeriesId")
    val id: Long,
    @JsonProperty("Title")
    val title: String,
)