package com.ic.mockserver.card.api

import com.ic.mockserver.card.api.response.CardMockResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CardMockServer {

    @GetMapping("/cards")
    fun getCardMockServerResponseTest(): CardMockResponse =
        CardMockResponse.ofCardResponseMock()
}