package com.ic.mockserver.card.api.exception

import com.ic.mockserver.card.api.response.CardError
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CardExceptionHandler {

    @ExceptionHandler(CardException::class)
    fun handleCardException(ex: CardException): ResponseEntity<CardError> {
        val errorCode = ex.cardErrorCode
        val cardError = CardError(
            code = errorCode.name,
            message = ex.message,
        )
        return ResponseEntity(cardError, errorCode.status)
    }
}