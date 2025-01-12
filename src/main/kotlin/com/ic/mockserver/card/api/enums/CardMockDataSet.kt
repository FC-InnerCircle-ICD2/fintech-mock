package com.ic.mockserver.card.api.enums

import java.math.BigDecimal

enum class CardMockDataSet (
    val cardNumber: String,
    val isValid: Boolean,
    val cardLimitAmount: BigDecimal,
    val cardUsedAmount: BigDecimal,
    val expiryDate: String
) {
    CARD1("1234-5678-9012-3456", true,  BigDecimal(5000), BigDecimal(3000), "12/25"),
    CARD2("5678-1234-5678-9012", true, BigDecimal(3000), BigDecimal(1000), "10/23"),
    CARD3("9876-5432-1098-7654", true, BigDecimal(10000), BigDecimal(2000), "01/27"),
    CARD4("4321-8765-4321-8765", true, BigDecimal(1500), BigDecimal(1000), "03/24"),
    CARD5("4567-8923-6378-3982", false, BigDecimal(10500), BigDecimal(1000), "03/28");

    companion object {
        val cardInfoMap: HashMap<String, CardMockDataSet> = hashMapOf(
            CARD1.cardNumber to CARD1,
            CARD2.cardNumber to CARD2,
            CARD3.cardNumber to CARD3,
            CARD4.cardNumber to CARD4,
            CARD5.cardNumber to CARD5
        )

        fun findByCardNumber(cardNumber: String): CardMockDataSet? {
            return cardInfoMap[cardNumber]  // HashMap에서 찾기
        }
    }
}