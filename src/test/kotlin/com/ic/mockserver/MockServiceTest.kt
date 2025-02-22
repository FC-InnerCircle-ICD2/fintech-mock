package com.ic.mockserver

import com.ic.mockserver.card.api.request.CardApproveRequest
import com.ic.mockserver.card.api.request.CardValidateRequest
import com.ic.mockserver.card.api.service.CardMockService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.RuntimeException
import java.math.BigDecimal
import kotlin.test.assertEquals

@SpringBootTest
class MockServiceTest(
    @Autowired val cardMockService: CardMockService
) {
    @Test
    fun cardValidatePass(){
        val cardValidateRequest = CardValidateRequest("1234-5678-9012-3456", "12/25", "123", "국민")
        val cardMockResponse = cardMockService.cardValidate(cardValidateRequest)
        val flag = true
        assertEquals(flag, cardMockResponse.isValid)
    }

    @Test
    fun cardWrongCVC(){
        val cardValidateRequest = CardValidateRequest("1234-5678-9012-3456", "12/25", "124", "국민")
        assertThrows<RuntimeException>{cardMockService.cardValidate(cardValidateRequest)}
    }

    @Test
    fun cardWrongExpDate(){
        val cardValidateRequest = CardValidateRequest("1234-5678-9012-3456", "11/25", "123", "국민")
        assertThrows<RuntimeException>{cardMockService.cardValidate(cardValidateRequest)}
    }

    @Test
    fun cardValidateNotFound(){
        val cardValidateRequest = CardValidateRequest("1234-5678-9012-9874", "12/25", "123", "국민")
        assertThrows<RuntimeException>{cardMockService.cardValidate(cardValidateRequest)}
    }

    @Test
    fun cardValidateExpired(){
        val cardValidateRequest = CardValidateRequest("5678-1234-5678-9012", "10/23", "456", "현대")
        assertThrows<RuntimeException>{cardMockService.cardValidate(cardValidateRequest)}
    }

    @Test
    fun cardWrongCompany(){
        val cardValidateRequest = CardValidateRequest("5678-1234-5678-9012", "10/23", "456", "수협")
        assertThrows<RuntimeException>{cardMockService.cardValidate(cardValidateRequest)}
    }

    @Test
    fun cardApprovePass(){
        val cardApproveRequest = CardApproveRequest("9876-5432-1098-7654", BigDecimal(7000))
        val cardMockResponse = cardMockService.cardApprove(cardApproveRequest)
        val flag = true
        assertEquals(flag, cardMockResponse.isValid)
    }

    @Test
    fun cardApproveExpired(){
        val cardApproveRequest = CardApproveRequest("5678-1234-5678-9012", BigDecimal(1))
        assertThrows<RuntimeException>{cardMockService.cardApprove(cardApproveRequest)}
    }

    @Test
    fun cardApproveNotFound(){
        val cardApproveRequest = CardApproveRequest("1234-5678-9012-9874",  BigDecimal(1000))
        assertThrows<RuntimeException>{cardMockService.cardApprove(cardApproveRequest)}
    }
}