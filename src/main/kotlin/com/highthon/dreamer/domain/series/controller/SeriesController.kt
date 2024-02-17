package com.highthon.dreamer.domain.series.controller

import com.highthon.dreamer.domain.series.service.SeriesService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/s")
class SeriesController(
    private val seriesService: SeriesService
) {

}