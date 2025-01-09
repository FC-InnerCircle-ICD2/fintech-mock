package com.ic.mockserver.card

import com.ic.mockserver.card.dto.CardMockResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CardMockServer {

    @GetMapping("/cards")
    fun getCardMockServerResponseTest(): CardMockResponse =
        CardMockResponse(message = "CardMockResponseTest")
}