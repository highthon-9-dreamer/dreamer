package com.highthon.dreamer.domain.series.persistence.repository

import com.highthon.dreamer.domain.series.model.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository: JpaRepository<Reply, Long> {

}
