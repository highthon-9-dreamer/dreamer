package com.highthon.dreamer.global.common.basic.exception

class NotEnoughDataException(val code: ErrorCode = ErrorCode.NOT_ENOUGH_DATA_ERROR): BasicException(code)