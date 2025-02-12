package com.ic.mockserver.card.api.enums

import java.math.BigDecimal

enum class CardMockDataSet(
    val cardNumber: String,
    val isValid: Boolean,
    val expiryDate: String,
    val cvc: String
) {
    CARD1("1234-5678-9012-3456", true, "12/25", "123"),
    CARD2("5678-1234-5678-9012", true, "10/23", "456"),
    CARD3("9876-5432-1098-7654", true, "01/27", "789"),
    CARD4("4321-8765-4321-8765", true, "03/24", "987"),
    CARD5("4567-8923-6378-3982", true, "03/28", "654");

    companion object {
        val cardMockDataMap: Map<String, CardMockDataSet> = values().associateBy { it.cardNumber }

        fun findByCardNumber(cardNumber: String): CardMockDataSet? {
            return cardMockDataMap[cardNumber]
        }
    }
}