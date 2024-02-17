package com.highthon.dreamer.domain.user.controller.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotEmpty

data class JoinRequest (
    @NotEmpty
    @JsonProperty("Name")
    val name: String,

    @NotEmpty
    @JsonProperty("Email")
    val email: String,

    @NotEmpty
    @JsonProperty("Password")
    val rawPassword: String,

    @NotEmpty
    @JsonProperty("Profile")
    val profile: String,
)
