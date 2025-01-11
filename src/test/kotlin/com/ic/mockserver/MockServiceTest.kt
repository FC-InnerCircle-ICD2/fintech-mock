package com.ic.mockserver

import com.ic.mockserver.card.api.request.CardApproveRequest
import com.ic.mockserver.card.api.request.CardValidateRequest
import com.ic.mockserver.card.api.service.CardMockService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.RuntimeException
import kotlin.test.assertEquals

@SpringBootTest
class MockServiceTest(
    @Autowired val cardMockService: CardMockService
) {
    @Test
    fun cardValidatePass(){
        val cardValidateRequest = CardValidateRequest("1234-5678-9012-3456")
        val cardMockResponse = cardMockService.cardValidate(cardValidateRequest)
        val flag = true
        assertEquals(flag, cardMockResponse.isValid)
    }

    @Test
    fun cardValidateInvalid(){
        val cardValidateRequest = CardValidateRequest("4567-8923-6378-3982")
        assertThrows<RuntimeException>{cardMockService.cardValidate(cardValidateRequest)}
    }

    @Test
    fun cardValidateNotFound(){
        val cardValidateRequest = CardValidateRequest("1234-5678-9012-9874")
        assertThrows<RuntimeException>{cardMockService.cardValidate(cardValidateRequest)}
    }

    @Test
    fun cardValidateExpired(){
        val cardValidateRequest = CardValidateRequest("5678-1234-5678-9012")
        assertThrows<RuntimeException>{cardMockService.cardValidate(cardValidateRequest)}
    }

    @Test
    fun cardApprovePass(){
        val cardApproveRequest = CardApproveRequest("9876-5432-1098-7654", 7000)
        val cardMockResponse = cardMockService.cardApprove(cardApproveRequest)
        val flag = true
        assertEquals(flag, cardMockResponse.isValid)
    }

    @Test
    fun cardApproveLimit(){
        val cardApproveRequest = CardApproveRequest("9876-5432-1098-7654", 9000)
        assertThrows<RuntimeException>{cardMockService.cardApprove(cardApproveRequest)}
    }

    @Test
    fun cardApproveExpired(){
        val cardApproveRequest = CardApproveRequest("5678-1234-5678-9012", 1)
        assertThrows<RuntimeException>{cardMockService.cardApprove(cardApproveRequest)}
    }

    @Test
    fun cardApproveNotFound(){
        val cardApproveRequest = CardApproveRequest("1234-5678-9012-9874",  1000)
        assertThrows<RuntimeException>{cardMockService.cardApprove(cardApproveRequest)}
    }
}