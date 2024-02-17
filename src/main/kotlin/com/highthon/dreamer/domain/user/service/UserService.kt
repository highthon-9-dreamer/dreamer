package com.highthon.dreamer.domain.user.service

import com.highthon.dreamer.domain.user.controller.request.JoinRequest
import com.highthon.dreamer.domain.user.controller.request.LoginRequest
import com.highthon.dreamer.domain.user.exception.UserConflictException
import com.highthon.dreamer.domain.user.exception.UserNotFoundException
import com.highthon.dreamer.domain.user.model.User
import com.highthon.dreamer.domain.user.repository.UserRepository
import com.highthon.dreamer.global.security.jwt.JwtGenerator
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtGenerator: JwtGenerator
) {
    fun login(loginRequest: LoginRequest) =
        userRepository.findOneByEmail(loginRequest.email).let {
            if (it == null || !passwordEncoder.matches(loginRequest.password, it!!.password))
                throw UserNotFoundException()

            jwtGenerator.generate(it.id.toString())
        }

    fun join(joinRequest: JoinRequest) {
        userRepository.existsByEmailOrName(joinRequest.email, joinRequest.name).let {
            if (it) throw UserConflictException()
            val encodedPassword = passwordEncoder.encode(joinRequest.rawPassword)

            val joinUserEntity = User(
                id = null,
                profile = joinRequest.profile,
                name = joinRequest.name,
                introduce = null,
                email = joinRequest.email,
                password = encodedPassword
            )

            userRepository.save(joinUserEntity)
        }
    }

}
