package com.ic.mockserver.card.api.exception

class CardException (cardErrorCode: CardErrorCode) : RuntimeException(){
    public val cardErrorCode: CardErrorCode = cardErrorCode
}