package com.highthon.dreamer.domain.series.repository

import com.highthon.dreamer.domain.series.model.Contents
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContentsRepository: JpaRepository<Contents, Long> {
    fun findAllByTitleLikeIgnoreCase(title: String): List<Contents>
}
