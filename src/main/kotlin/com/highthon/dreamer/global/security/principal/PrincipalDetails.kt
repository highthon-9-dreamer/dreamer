package com.highthon.dreamer.global.security.principal

import com.highthon.dreamer.domain.user.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class PrincipalDetails (
    private val user: User
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = ArrayList()

    override fun getPassword(): String? = user.password

    override fun getUsername(): String? = user.name

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}