package com.highthon.dreamer.global.configs

import com.highthon.dreamer.global.common.basic.exception.BasicException
import com.highthon.dreamer.global.common.basic.exception.ErrorCode
import com.highthon.dreamer.global.common.basic.response.BasicResponse
import com.highthon.dreamer.global.common.basic.response.MsgResponse
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.resource.NoResourceFoundException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BasicException::class)
    fun basicExceptionHandler(e: BasicException) = BasicResponse.error(e.errorCode)

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun jsonExceptionHandler(e: HttpMessageNotReadableException) =
        BasicResponse.error(ErrorCode.NON_BODY_ERROR)

    @ExceptionHandler(NoResourceFoundException::class)
    fun noResourceHandler(e: Exception): ResponseEntity<MsgResponse> {
        return BasicResponse.error(ErrorCode.NOT_FOUND_ERROR)
    }

    @ExceptionHandler(Exception::class)
    fun unexpectedExceptionHandler(e: Exception): ResponseEntity<MsgResponse> {
        e.printStackTrace()
        return BasicResponse.error(ErrorCode.UNEXPECTED_ERROR)
    }
}