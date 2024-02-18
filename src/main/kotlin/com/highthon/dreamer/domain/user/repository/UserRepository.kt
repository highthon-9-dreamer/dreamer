package com.highthon.dreamer.domain.user.repository

import com.highthon.dreamer.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User, Long> {
    fun findOneByEmail(email: String): User?
    fun existsByEmailOrName(email: String, name: String): Boolean
}