package com.highthon.dreamer.domain.user.model

import jakarta.persistence.*
import java.util.*

@Entity
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
)