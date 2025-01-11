package com.ic.mockserver.card.api.enums

enum class CardInfoEnum (
    val cardNumber: String,
    val isValid: Boolean,
    val cardLimitAmount: Int,
    val cardUsedAmount: Int,
    val expiryDate: String
) {
    CARD1("1234-5678-9012-3456", true, 5000, 3000, "12/25"),
    CARD2("5678-1234-5678-9012", true, 3000, 1000, "10/23"),
    CARD3("9876-5432-1098-7654", true, 10000, 2000, "01/27"),
    CARD4("4321-8765-4321-8765", true, 1500, 1000, "03/24"),
    CARD5("4567-8923-6378-3982", false, 10500, 1000, "03/28");

    companion object {
        fun findByCardNumber(cardNumber: String): CardInfoEnum? {
            return values().find { it.cardNumber == cardNumber }
        }
    }
}
