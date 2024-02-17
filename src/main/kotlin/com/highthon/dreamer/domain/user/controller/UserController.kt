package com.highthon.dreamer.domain.user.controller

import com.highthon.dreamer.domain.user.controller.request.JoinRequest
import com.highthon.dreamer.domain.user.controller.request.LoginRequest
import com.highthon.dreamer.domain.user.service.UserService
import com.highthon.dreamer.global.common.basic.response.BasicResponse
import com.highthon.dreamer.global.security.jwt.dto.TokenDto
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/u")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/login")
    fun login(@RequestBody @Valid loginRequest: LoginRequest) =
        userService.login(loginRequest).let {
            BasicResponse.ok(TokenDto(it))
        }

    @PostMapping("/join")
    fun join(@RequestBody @Valid joinRequest: JoinRequest) =
        userService.join(joinRequest).run {
            BasicResponse.created("회원가입에 성공하였습니다.")
        }
}