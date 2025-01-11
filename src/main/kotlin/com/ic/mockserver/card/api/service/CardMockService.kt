package com.ic.mockserver.card.api.service

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import com.ic.mockserver.card.api.enums.CardInfoEnum
import com.ic.mockserver.card.api.exception.CardException
import com.ic.mockserver.card.api.request.CardApproveRequest
import com.ic.mockserver.card.api.request.CardValidateRequest
import com.ic.mockserver.card.api.response.CardMockResponse
import org.springframework.stereotype.Service

@Service
class CardMockService {
    
    //카드 유효성 검증
    fun cardValidate(
        request: CardValidateRequest
    ):CardMockResponse  {
        val cardInfo = CardInfoEnum.findByCardNumber(request.cardNumber)
        return if (cardInfo != null) {
            //카드 유효 여부
            if (!cardInfo.isValid) {
                throw CardException("Card ${request.cardNumber} is not valid")
            } 
            //카드 만료 여부
            else if(calCardDate(cardInfo)!! < calNowDate()){
                throw CardException("Card ${cardInfo.expiryDate} is expired")
            }
            CardMockResponse.from(cardInfo)
        }
        //카드 존재 여부
        else {
            throw CardException("Card ${request.cardNumber} not found")
        }
    }

    //카드 승인
    fun cardApprove(
        request: CardApproveRequest
    ):CardMockResponse  {
        val cardInfo = CardInfoEnum.findByCardNumber(request.cardNumber)
        return if (cardInfo != null) {
            // 카드 한도 체크
            if (cardInfo.cardLimitAmount - cardInfo.cardUsedAmount < request.amount) {
                throw CardException("Card ${request.cardNumber} has insufficient limit")
            }
            //카드 만료 여부
            else if(calCardDate(cardInfo)!! < calNowDate()){
                throw CardException("Card ${cardInfo.expiryDate} is expired")
            }
            // 승인 처리 성공
            CardMockResponse.from(cardInfo)
        }
        //카드 존재 여부
        else {
            throw CardException("Card ${request.cardNumber} not found")
        }
    }

    fun calNowDate() : Int{
        val currentDate = Clock.System.now()
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .date
        return currentDate.year * 12 + currentDate.monthNumber
    }

    fun calCardDate(cardInfo: CardInfoEnum) : Int? {
        val expiryDateSplit = cardInfo?.expiryDate?.split("/")

        // month와 year를 각각 변환, 유효하지 않으면 null
        val month = expiryDateSplit?.get(0)?.toIntOrNull()
        val year = expiryDateSplit?.get(1)?.toIntOrNull()
        // month와 year가 모두 유효한 경우에만 합산
        return if (month != null && year != null) month + ((year + 2000) * 12) else 0
    }
}
