package com.highthon.dreamer.global.security.principal

import com.highthon.dreamer.domain.user.repository.UserRepository
import com.highthon.dreamer.global.common.basic.exception.NotEnoughDataException
import com.highthon.dreamer.global.security.exception.LoginInfoNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class PrincipalDetailsService(
    private val userRepository: UserRepository,
): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails =
        if (!username.isNullOrBlank()) PrincipalDetails(
            userRepository.findByIdOrNull(username.toLong()) ?:
            throw LoginInfoNotFoundException()
        ) else throw NotEnoughDataException()
}