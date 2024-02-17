package com.highthon.dreamer.global.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*

@Component
class JwtGenerator(
    private val jwtProperties: JwtProperties,
) {
    fun generate(userId: String): String =
        "${jwtProperties.jwtPrefix} ${generateToken(userId, jwtProperties.accessKey, jwtProperties.accessExp)}"

    private fun generateToken(userId: String, secret: Key, expiredAt: Int) =
        Jwts.builder()
            .signWith(secret, SignatureAlgorithm.HS512)
            .setSubject(userId)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiredAt * 1000))
            .compact()
}