package com.highthon.dreamer.global.security.exception

import com.highthon.dreamer.global.common.basic.exception.BasicException
import com.highthon.dreamer.global.common.basic.exception.ErrorCode

class LoginInfoNotFoundException(override val errorCode: ErrorCode = ErrorCode.LOGIN_INFO_NOT_FOUND_ERROR) : BasicException(errorCode) {

}
