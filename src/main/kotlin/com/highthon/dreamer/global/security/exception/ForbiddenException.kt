package com.highthon.dreamer.global.security.exception

import com.highthon.dreamer.global.common.basic.exception.BasicException
import com.highthon.dreamer.global.common.basic.exception.ErrorCode

class ForbiddenException(
    val code: ErrorCode = ErrorCode.FORBIDDEN_ERROR
) : BasicException(code)
