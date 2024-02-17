package com.highthon.dreamer.domain.series.persistence.customRepository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class CustomContentRepository(
    private val query: JPAQueryFactory
) {

//    fun list(contentListRequest: ContentListRequest) =

}