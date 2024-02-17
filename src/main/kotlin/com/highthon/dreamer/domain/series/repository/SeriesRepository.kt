package com.highthon.dreamer.domain.series.repository

import com.highthon.dreamer.domain.series.model.Series
import org.springframework.data.jpa.repository.JpaRepository

interface SeriesRepository: JpaRepository<Series, Long> {

}
