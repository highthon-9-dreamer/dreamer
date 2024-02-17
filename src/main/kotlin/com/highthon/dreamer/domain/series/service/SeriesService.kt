package com.highthon.dreamer.domain.series.service

import com.highthon.dreamer.domain.series.controller.response.MySeriesListResponse
import com.highthon.dreamer.domain.series.repository.SeriesRepository
import com.highthon.dreamer.domain.user.model.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SeriesService(
    private val seriesRepository: SeriesRepository
) {
    fun myList(user: User) =
        seriesRepository.findAllByUserIdOrderByUpdatedAt(user.id!!).let {
            it.map {
                MySeriesListResponse(it.id!!, it.title!!)
            }
        }

}
