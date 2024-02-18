package com.highthon.dreamer.domain.series.controller

import com.highthon.dreamer.domain.series.controller.request.AddContentRequest
import com.highthon.dreamer.domain.series.service.ContentsService
import com.highthon.dreamer.global.common.basic.response.BasicResponse
import com.highthon.dreamer.global.security.principal.PrincipalDetails
import jakarta.validation.Valid
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

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
        contentsService.add(addContentRequest, principalDetails.user.email!!).let {
            BasicResponse.created(it.toString())

        }

    @GetMapping("/list")
    fun list() =
        BasicResponse.ok(contentsService.list())

    @GetMapping("/search")
    fun search(@RequestParam(name = "keyword") keyword: String) =
        BasicResponse.ok(contentsService.search(keyword))

    @GetMapping("/{contentsId}")
    fun detail(@PathVariable("contentsId") contentsId: Long) =
        BasicResponse.ok(contentsService.detail(contentsId))
}