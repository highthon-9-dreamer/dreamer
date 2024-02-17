package com.highthon.dreamer.global.common.basic.exception

open class BasicException(
    open val errorCode: ErrorCode
): RuntimeException()