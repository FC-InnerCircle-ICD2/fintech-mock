package com.ic.mockserver.card.api.exception

import org.springframework.http.HttpStatus

enum class CardErrorCode(status: HttpStatus, message: String) {
    CARD_NOT_FOUND(HttpStatus.NOT_FOUND, "The card could not be found."),
    CARD_NOT_VALID(HttpStatus.BAD_REQUEST, "The card is invalid."),
    CARD_EXPIRED(HttpStatus.BAD_REQUEST, "That card has expired."),
    CARD_WRONG_CVC(HttpStatus.BAD_REQUEST, "The CVC on this card does not match."),
    CARD_WRONG_EXP_DATE(HttpStatus.BAD_REQUEST, "The expiration date does not match the expiration date on this card."),
    CARD_LIMIT_EXCEED(HttpStatus.BAD_REQUEST, "The limit on that card has been exceeded.");

    public val status: HttpStatus = status
    public val message: String = message
}