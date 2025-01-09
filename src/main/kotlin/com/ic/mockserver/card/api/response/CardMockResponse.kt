package com.ic.mockserver.card.api.response


data class CardMockResponse(
    val message: String,
)  {
    companion object {
        fun ofCardResponseMock(): CardMockResponse =
            CardMockResponse(
                message = "Mocking Message",
            )
    }
}
