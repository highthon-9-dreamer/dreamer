package com.highthon.dreamer.domain.user.model

import com.highthon.dreamer.domain.series.model.Contents
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "`name`")
class User (
    @Id
    @Column(name = "userId", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var profile: String?,
    var name: String?,
    var email: String?,
    var introduce: String?,
    var password: String?,

    @OneToMany(fetch = FetchType.LAZY,
        cascade = [CascadeType.PERSIST, CascadeType.REMOVE],
        mappedBy = "user")
    var contents: List<Contents>?,
)