package com.highthon.dreamer.domain.user.controller.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotEmpty

data class LoginRequest (
    @NotEmpty
    @JsonProperty("Email")
    val email: String,

    @NotEmpty
    @JsonProperty("Password")
    val password: String
)
