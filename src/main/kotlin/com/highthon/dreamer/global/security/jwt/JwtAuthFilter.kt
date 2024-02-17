package com.highthon.dreamer.global.security.jwt

import com.highthon.dreamer.domain.user.exception.UserNotFoundException
import com.highthon.dreamer.global.security.principal.PrincipalDetailsService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtAuthFilter(
    private val jwtParser: JwtParser,
    private val principalDetailsService: PrincipalDetailsService,
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            val accessToken = jwtParser.parseAccessToken(request)
            if (!accessToken.isNullOrBlank()) {
                val userEmail = jwtParser.authentication(accessToken, true)
                SecurityContextHolder.clearContext()

                val userDetails = principalDetailsService.loadUserByUsername(userEmail)

                val securityContext = SecurityContextHolder.getContext()
                securityContext.authentication = UsernamePasswordAuthenticationToken(userDetails, "", ArrayList())
            }

            filterChain.doFilter(request, response)
        } catch (e: UserNotFoundException) {
            response.sendError(e.errorCode.code.value(), e.errorCode.msg)
        }
    }
}