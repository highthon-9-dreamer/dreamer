package com.highthon.dreamer.domain.user.exception

import com.highthon.dreamer.global.common.basic.exception.BasicException
import com.highthon.dreamer.global.common.basic.exception.ErrorCode

class UserConflictException(override val errorCode: ErrorCode = ErrorCode.USER_CONFLICT_ERROR) : BasicException(errorCode) {

}
