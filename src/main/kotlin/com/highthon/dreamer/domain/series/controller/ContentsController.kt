package com.highthon.dreamer.domain.series.controller

import com.highthon.dreamer.domain.series.controller.request.AddContentRequest
import com.highthon.dreamer.domain.series.service.ContentsService
import com.highthon.dreamer.global.common.basic.response.BasicResponse
import com.highthon.dreamer.global.security.principal.PrincipalDetails
import jakarta.validation.Valid
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/c")
class ContentsController(
    private val contentsService: ContentsService
) {


    @PostMapping("/add")
    fun addContent(
        @RequestBody @Valid addContentRequest: AddContentRequest,
        @AuthenticationPrincipal principalDetails: PrincipalDetails
        ) =
        contentsService.add(addContentRequest, principalDetails.user.id!!).let {
            BasicResponse.created("생성되었습니다.")
        }
}