package com.highthon.dreamer.domain.series.exception

import com.highthon.dreamer.global.common.basic.exception.BasicException
import com.highthon.dreamer.global.common.basic.exception.ErrorCode

class ContentsNotFoundException(override val errorCode: ErrorCode =ErrorCode.CONTENTS_NOT_FOUND_ERROR) : BasicException(errorCode) {

}
