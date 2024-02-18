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
import com.highthon.dreamer.domain.user.exception.UserNotFoundException
import com.highthon.dreamer.domain.user.repository.UserRepository
import jakarta.persistence.EntityManager
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class ContentsService(
    private val seriesRepository: SeriesRepository,
    private val contentsRepository: ContentsRepository,
    private val userRepository: UserRepository,
    private val em: EntityManager
) {
    fun add(addContentRequest: AddContentRequest, userEmail: String): Long? =
        addContentRequest.let {
            val user = userRepository.findOneByEmail(userEmail) ?: throw UserNotFoundException()

            val content = Contents(
                id = null,
                title = addContentRequest.title,
                description = addContentRequest.description,
                number = null,
                series = null,
                user = user,
                replies = null
            )
            if (it.seriesId == null) {
                val contents = ArrayList<Contents>()
                content.number = 1

                val series = Series(
                    id = null,
                    title = it.seriesTitle,
                    contents = contents,
                    userId = user.id,
                    lastNumber = 1
                )
                content.series = series
                contents.add(content)
                seriesRepository.save(series)

                em.flush()
                return content.id
            } else {
                val series = seriesRepository.findByIdOrNull(addContentRequest.seriesId)
                    ?: throw SeriesNotFoundException()

                content.series = series
                content.number = series.lastNumber!! + 1L
                series.contents = series.contents!! + content

                em.flush()
                return content.id
            }

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

    fun search(keyword: String) =
        contentsRepository.findAllByTitleLikeIgnoreCase(keyword)

}
