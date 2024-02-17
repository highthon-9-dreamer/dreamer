package com.highthon.dreamer.domain.user.model

import com.highthon.dreamer.domain.series.model.Contents
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "`name`")
class User (
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID?,
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