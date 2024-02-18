package com.highthon.dreamer.domain.series.model

import com.highthon.dreamer.domain.user.model.User
import com.highthon.dreamer.global.common.basic.entity.BasicTimeEntity
import jakarta.persistence.*

@Entity
class Contents (

    @Id @Column(name = "contents_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    var title: String?,
    var description: String?,

    var number: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="series_id", nullable = false)
    var series: Series?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User?,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "contents")
    var replies: List<Reply>?,
): BasicTimeEntity()