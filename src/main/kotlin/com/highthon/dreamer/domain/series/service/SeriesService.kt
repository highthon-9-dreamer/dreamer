package com.highthon.dreamer.domain.series.service

import com.highthon.dreamer.domain.series.repository.SeriesRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SeriesService(
    private val seriesRepository: SeriesRepository
) {

}
