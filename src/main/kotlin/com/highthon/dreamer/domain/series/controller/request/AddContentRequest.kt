package com.highthon.dreamer.domain.series.controller.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotEmpty

data class AddContentRequest (

    @NotEmpty
    @JsonProperty("Title")
    val title: String,

    @NotEmpty
    @JsonProperty("Description")
    val description: String,

    @NotEmpty
    @JsonProperty("SeriesTitle")
    val seriesTitle: String,

    @JsonProperty("SeriesId")
    val seriesId: Long?,
)
