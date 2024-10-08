package com.highthon.dreamer.global.security.exception

import com.highthon.dreamer.global.common.basic.exception.BasicException
import com.highthon.dreamer.global.common.basic.exception.ErrorCode

class UnAuthorizedException(
    override val errorCode: ErrorCode = ErrorCode.UNAUTHORIZED_ERROR
): BasicException(errorCode)