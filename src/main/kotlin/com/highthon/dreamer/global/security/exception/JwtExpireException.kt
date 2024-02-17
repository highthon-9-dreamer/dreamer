package com.highthon.dreamer.global.security.exception

import com.highthon.dreamer.global.common.basic.exception.BasicException
import com.highthon.dreamer.global.common.basic.exception.ErrorCode

class JwtExpireException(override val errorCode: ErrorCode = ErrorCode.JWT_EXPIRE_ERROR) : BasicException(errorCode) {

}
