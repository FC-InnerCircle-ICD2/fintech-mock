package com.ic.mockserver.card.api.exception


open class CardException(
    val cardErrorCode: CardErrorCode,
    override val message: String = cardErrorCode.message,
    override val cause: Throwable? = null
) : RuntimeException(message, cause) {}