package com.ic.mockserver.card.api.service

import com.ic.mockserver.card.api.enums.CardMockDataSet
import com.ic.mockserver.card.api.exception.CardErrorCode
import com.ic.mockserver.card.api.exception.CardException
import com.ic.mockserver.card.api.request.CardApproveRequest
import com.ic.mockserver.card.api.request.CardValidateRequest
import com.ic.mockserver.card.api.response.CardMockResponse
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.springframework.stereotype.Service

@Service
class CardMockService {
    
    //카드 유효성 검증
    fun cardValidate(
        request: CardValidateRequest
    ):CardMockResponse  {
        val cardInfo = CardMockDataSet.findByCardNumber(request.cardNumber)
        return if (cardInfo != null) {
            //유효기간 일치 여부
            if(request.expiryDate != cardInfo.expiryDate){
                throw CardException(CardErrorCode.CARD_WRONG_EXP_DATE)
            }
            //CVC 일치 여부
            if(request.cvc != cardInfo.cvc){
                throw CardException(CardErrorCode.CARD_WRONG_CVC)
            }
            //카드사 일치 여부
            if(request.cardCompany != cardInfo.cardCompany){
                throw CardException(CardErrorCode.CARD_WRONG_CARD_COMPANY)
            }
            //카드 유효 여부
            if (!cardInfo.isValid) {
                throw CardException(CardErrorCode.CARD_NOT_VALID)
            } 
            //카드 만료 여부
            if(calCardDate(cardInfo)!! < calNowDate()){
                throw CardException(CardErrorCode.CARD_EXPIRED)
            }
            CardMockResponse.from(cardInfo)
        }
        //카드 존재 여부
        else {
            throw CardException(CardErrorCode.CARD_NOT_FOUND)
        }
    }

    //카드 승인
    fun cardApprove(
        request: CardApproveRequest
    ):CardMockResponse  {
        val cardInfo = CardMockDataSet.findByCardNumber(request.cardNumber)
        return if (cardInfo != null) {
            //카드 만료 여부
            if(calCardDate(cardInfo)!! < calNowDate()){
                throw CardException(CardErrorCode.CARD_EXPIRED)
            }
            // 승인 처리 성공
            CardMockResponse.from(cardInfo)
        }
        //카드 존재 여부
        else {
            throw CardException(CardErrorCode.CARD_NOT_FOUND)
        }
    }

    fun calNowDate() : Int{
        val currentDate = Clock.System.now()
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .date
        return currentDate.year * 12 + currentDate.monthNumber
    }

    fun calCardDate(cardInfo: CardMockDataSet) : Int? {
        val expiryDateSplit = cardInfo?.expiryDate?.split("/")

        // month와 year를 각각 변환, 유효하지 않으면 null
        val month = expiryDateSplit?.get(0)?.toIntOrNull()
        val year = expiryDateSplit?.get(1)?.toIntOrNull()
        // month와 year가 모두 유효한 경우에만 합산
        return if (month != null && year != null) month + ((year + 2000) * 12) else 0
    }
}
