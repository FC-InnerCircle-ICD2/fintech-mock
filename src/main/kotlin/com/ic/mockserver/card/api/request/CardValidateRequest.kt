package com.ic.mockserver.card.api.request

import jakarta.validation.constraints.NotBlank


data class CardValidateRequest(
    @field:NotBlank
    val cardNumber: String
)
