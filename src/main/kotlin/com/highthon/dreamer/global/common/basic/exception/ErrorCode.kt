package com.highthon.dreamer.global.common.basic.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val msg: String,
    val code: HttpStatus
) {
    FORBIDDEN_ERROR("접근 권한이 없습니다.", HttpStatus.FORBIDDEN),
    UNAUTHORIZED_ERROR("로그인이 필요한 작업입니다.", HttpStatus.UNAUTHORIZED),
    USER_NOT_FOUND_ERROR("계정을 찾을 수 없습니다.", HttpStatus.NO_CONTENT),
    UNEXPECTED_ERROR("서버에서 오류가 발생하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    NON_BODY_ERROR("데이터가 정상적으로 들어오지 않았습니다.", HttpStatus.BAD_REQUEST),
    NOT_ENOUGH_DATA_ERROR("필수 요청 데이터가 정상적으로 입력되지 않았습니다.", HttpStatus.BAD_REQUEST),
    USER_CONFLICT_ERROR("해당 이메일은 이미 가입이 완료되었습니다.", HttpStatus.CONFLICT),
    REFRESH_TOKEN_NOT_FOUND("로그인 정보를 찾을 수 없습니다.", HttpStatus.NO_CONTENT),
    CATEGORY_NOT_FOUND_ERROR("카테고리를 찾을 수 없습니다.", HttpStatus.NO_CONTENT),
    SERVICE_CONFLICT_ERROR("이미 존재하는 서비스 입니다", HttpStatus.CONFLICT),
    SERIES_NOT_FOUND_ERROR("시리즈를 찾을 수 없습니다.", HttpStatus.NO_CONTENT),
    CONTENTS_NOT_FOUND_ERROR("컨텐츠를 찾을 수 업습니다.", HttpStatus.NO_CONTENT),
    JWT_EXPIRE_ERROR("토큰이 만료되었습니다.", HttpStatus.UNAUTHORIZED),
    LOGIN_INFO_NOT_FOUND_ERROR("로그인 정보의 유저를 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUND_ERROR("페이지를 찾을 수 없습니다", HttpStatus.NOT_FOUND),
}