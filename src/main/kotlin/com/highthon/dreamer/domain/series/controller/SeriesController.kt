package com.highthon.dreamer.domain.series.controller

import com.highthon.dreamer.domain.series.service.SeriesService
import com.highthon.dreamer.global.common.basic.response.BasicResponse
import com.highthon.dreamer.global.security.principal.PrincipalDetails
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/s")
class SeriesController(
    private val seriesService: SeriesService
) {

    @GetMapping("/my-series")
    fun mySeriesList(@AuthenticationPrincipal principal: PrincipalDetails) =
        BasicResponse.ok(seriesService.myList(principal.user))
}