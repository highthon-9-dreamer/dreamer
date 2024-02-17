package com.highthon.dreamer.domain.user.exception

import com.highthon.dreamer.global.common.basic.exception.BasicException
import com.highthon.dreamer.global.common.basic.exception.ErrorCode

class UserNotFoundException(override val errorCode: ErrorCode = ErrorCode.USER_NOT_FOUND_ERROR): BasicException(errorCode)