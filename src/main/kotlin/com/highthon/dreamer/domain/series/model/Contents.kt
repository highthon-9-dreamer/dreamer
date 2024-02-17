package com.highthon.dreamer.domain.series.model

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
    @JoinColumn(name ="series")
    var series: Series?
)