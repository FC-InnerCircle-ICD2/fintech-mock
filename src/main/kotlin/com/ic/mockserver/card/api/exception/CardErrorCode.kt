package com.ic.mockserver.card.api.exception

import org.springframework.http.HttpStatus

enum class CardErrorCode(status: HttpStatus, message: String) {
    CARD_NOT_FOUND(HttpStatus.NOT_FOUND, "발급된 카드가 아닙니다."),
    CARD_NOT_VALID(HttpStatus.BAD_REQUEST, "카드가 유효하지 않습니다."),
    CARD_EXPIRED(HttpStatus.BAD_REQUEST, "카드가 만료되었습니다."),
    CARD_WRONG_CVC(HttpStatus.BAD_REQUEST, "카드의 CVC가 일치하지 않습니다."),
    CARD_WRONG_EXP_DATE(HttpStatus.BAD_REQUEST, "카드의 만료 일자가 일치하지 않습니다."),
    CARD_WRONG_CARD_COMPANY(HttpStatus.BAD_REQUEST, "카드 번호의 카드사 정보와 일치하지 않습니다.");

    public val status: HttpStatus = status
    public val message: String = message
}