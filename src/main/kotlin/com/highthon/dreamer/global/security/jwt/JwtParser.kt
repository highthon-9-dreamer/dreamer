package com.highthon.dreamer.global.security.jwt

import com.highthon.dreamer.global.security.exception.ForbiddenException
import com.highthon.dreamer.global.security.exception.JwtExpireException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component
import java.security.Key

@Component
class JwtParser(
    private val jwtProperties: JwtProperties,
) {
    /**
     * request에서 header 분리후 perfix까지 분리
     * prefix 없으면 null 리턴
     */
    fun parseAccessToken(request: HttpServletRequest): String? =
        request.getHeader("X-Auth-Token")
            .let { it ?: return null }
            .let {
                if (it.startsWith(jwtProperties.jwtPrefix))
                    it.replace(jwtProperties.jwtPrefix, "").trim()
                else null
            }

    /**
     * 유저 아이디 반환
      */
    fun authentication(accessOrRefreshToken: String, isAccessToken: Boolean) =
        isAccessToken.let {
            val secret = jwtProperties.accessKey

            getTokenBody(accessOrRefreshToken, secret).subject ?: throw ForbiddenException()
        }

    private fun getTokenBody(token: String, secret: Key): Claims {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredJwtException) {
            throw JwtExpireException()
        }
    }
}