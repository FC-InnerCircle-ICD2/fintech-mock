package com.ic.mockserver.card.api.response

import com.ic.mockserver.card.api.enums.CardMockDataSet

data class CardMockResponse(
    val cardNumber: String,
    val isValid: Boolean
){
    companion object{
        fun from(enum: CardMockDataSet):CardMockResponse =
            CardMockResponse(
                cardNumber = enum.cardNumber,
                isValid = enum.isValid
            )
    }
}
