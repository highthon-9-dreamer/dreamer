package com.highthon.dreamer.global.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.highthon.dreamer.global.common.basic.exception.BasicException
import com.highthon.dreamer.global.common.basic.exception.ErrorCode
import com.highthon.dreamer.global.common.basic.response.MsgResponse
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter

class ExceptionFilter: OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BasicException) {
            exceptionToResponse(e.errorCode, response)
        } catch (e: Exception) {
            e.printStackTrace()
            exceptionToResponse(ErrorCode.UNEXPECTED_ERROR, response)
        }
    }

    private fun exceptionToResponse(errorCode: ErrorCode, response: HttpServletResponse) {
        response.status = errorCode.code.value()
        response.contentType = "application/json"
        response.characterEncoding = "utf-8"
        val errorResponse = MsgResponse(errorCode.msg)
        val errorResponseToJson = ObjectMapper().writeValueAsString(errorResponse)
        response.writer.write(errorResponseToJson)
    }
}