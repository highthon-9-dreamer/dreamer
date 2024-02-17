package com.highthon.dreamer.domain.series.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.highthon.dreamer.global.common.basic.entity.BasicTimeEntity
import jakarta.persistence.*
import java.util.*

@Entity
class Reply (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    var id: Long?,
    var userId: UUID?,
    var content: String?,

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
        cascade = [CascadeType.PERSIST, CascadeType.REMOVE])
    @JoinColumn(name = "contents_id")
    var contents: Contents
): BasicTimeEntity()