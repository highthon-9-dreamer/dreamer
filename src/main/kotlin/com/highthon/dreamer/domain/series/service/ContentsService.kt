package com.highthon.dreamer.domain.series.service

import com.highthon.dreamer.domain.series.controller.request.AddContentRequest
import com.highthon.dreamer.domain.series.exception.SeriesNotFoundException
import com.highthon.dreamer.domain.series.model.Contents
import com.highthon.dreamer.domain.series.model.Series
import com.highthon.dreamer.domain.series.repository.ContentsRepository
import com.highthon.dreamer.domain.series.repository.SeriesRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class ContentsService(
    private val seriesRepository: SeriesRepository,
    private val contentsRepository: ContentsRepository
) {
    fun add(addContentRequest: AddContentRequest, userId: UUID) =
        addContentRequest.let {
            val content = Contents(
                id = null,
                title = addContentRequest.title,
                description = addContentRequest.description,
                number = 1,
                series = null
            )
            if (it.seriesId == null) {
                val contents = ArrayList<Contents>()
                contents.add(content)

                seriesRepository.save(
                    Series(
                        id = null,
                        title = it.seriesTitle,
                        contents = contents,
                        userId = userId,
                        lastNumber = 1)
                )

                return
            }

            val series = seriesRepository.findByIdOrNull(addContentRequest.seriesId)
                ?: throw SeriesNotFoundException()

            series.contents = series.contents!! + content
        }
}
