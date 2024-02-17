package com.highthon.dreamer.global.security.principal

import com.highthon.dreamer.domain.user.exception.UserNotFoundException
import com.highthon.dreamer.domain.user.repository.UserRepository
import com.highthon.dreamer.global.common.basic.exception.NotEnoughDataException
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
            userRepository.findByIdOrNull(UUID.fromString(username)) ?:
            throw UserNotFoundException()
        ) else throw NotEnoughDataException()
}