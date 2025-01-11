package com.ic.mockserver.card.api.response

import com.ic.mockserver.card.api.enums.CardInfoEnum

data class CardMockResponse(
    val cardNumber: String,
    val isValid: Boolean
){
    companion object{
        fun from(enum: CardInfoEnum):CardMockResponse =
            CardMockResponse(
                cardNumber = enum.cardNumber,
                isValid = enum.isValid
            )
    }
}
