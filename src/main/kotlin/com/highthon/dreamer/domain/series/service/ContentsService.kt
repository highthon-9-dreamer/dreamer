package com.highthon.dreamer.domain.series.service

import com.highthon.dreamer.domain.series.controller.request.AddContentRequest
import com.highthon.dreamer.domain.series.controller.response.ContentDetailsResponse
import com.highthon.dreamer.domain.series.controller.response.ContentsListResponse
import com.highthon.dreamer.domain.series.exception.ContentsNotFoundException
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
                series = null,
                user = null,
                replies = null
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

    fun list() =
        contentsRepository.findAll().map {
            ContentsListResponse(
                it.title!!,
                it.createdAt!!,
                it.replies!!.size,
                it.user!!.name!!,
                it.user!!.id!!
            )
        }

    fun detail(contentsId: Long) =
        contentsRepository.findByIdOrNull(contentsId).let {
            if (it == null) throw ContentsNotFoundException()
            val replies = it.replies!!.map {
                ContentDetailsResponse.Companion.Reply(
                    it.id!!,
                    it.userId.toString(),
                    it.content!!,
                    it.userId!!
                )
            }

            ContentDetailsResponse(
                contentId = it.id!!,
                title = it.title!!,
                seriesTitle = it.series!!.title!!,
                number = it.number!!,
                description = it.description!!,
                createdBy = ContentDetailsResponse.Companion.User(
                    userId = it.user!!.id!!,
                    profile = it.user!!.profile!!,
                    name = it.user!!.name!!,
                    email = it.user!!.email!!,
                    introduce = it.user!!.introduce!!
                ),
                replies = replies
            )
        }
}
