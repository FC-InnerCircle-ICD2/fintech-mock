package com.ic.mockserver.card.api.request

import jakarta.validation.constraints.NotBlank


data class CardApproveRequest(
    @field:NotBlank
    val cardNumber: String,

    @field:NotBlank
    val amount: Int
)
