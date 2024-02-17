package com.highthon.dreamer.global.common.basic.model

import java.time.LocalDateTime

abstract class BasicTime {
    var updatedAt: LocalDateTime? = null
    var createdAt: LocalDateTime? = null
}