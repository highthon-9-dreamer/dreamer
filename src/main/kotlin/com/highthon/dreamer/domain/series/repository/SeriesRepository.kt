package com.highthon.dreamer.domain.series.repository

import com.highthon.dreamer.domain.series.model.Series
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SeriesRepository: JpaRepository<Series, Long> {
    fun findAllByUserIdOrderByUpdatedAt(userId: UUID): List<Series>
}
