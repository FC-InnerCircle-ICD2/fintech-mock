package com.ic.mockserver.card.api

import com.ic.mockserver.card.api.request.CardApproveRequest
import com.ic.mockserver.card.api.request.CardValidateRequest
import com.ic.mockserver.card.api.response.CardMockResponse
import com.ic.mockserver.card.api.service.CardMockService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CardMockController (
    private val cardMockService: CardMockService,
){
    @PostMapping("/cardValidate")
    fun cardValidate(
        @RequestBody request: CardValidateRequest
    ): CardMockResponse {
        return cardMockService.cardValidate(request)
    }

    @PostMapping("/cardApprove")
    fun cardApprove(
        @RequestBody request: CardApproveRequest
    ): CardMockResponse {
        return cardMockService.cardApprove(request)
    }
}