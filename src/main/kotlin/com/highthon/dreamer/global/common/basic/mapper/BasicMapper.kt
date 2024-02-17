package com.highthon.dreamer.global.common.basic.mapper

interface BasicMapper<D, E> {

    fun toDomain(entity: E): D
    fun toEntity(domain: D): E
}