package com.highthon.dreamer.domain.series.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.highthon.dreamer.global.common.basic.entity.BasicTimeEntity
import jakarta.persistence.*
import java.util.*

@Entity
class Series (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id")
    var id: Long?,

    var title: String?,

    /**
     * 최신화 번호
     */
    var lastNumber: Long?,

    @Column(updatable = false, nullable = false)
    var userId: Long?,

    @OneToMany(
        cascade = [CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE],
        fetch = FetchType.LAZY, mappedBy = "series")
    @JsonIgnore
    var contents: List<Contents>?
): BasicTimeEntity()