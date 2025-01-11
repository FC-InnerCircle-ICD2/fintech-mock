# Pay200 Mock Server 🚀

Pay200 팀에서 제공하는 핀테크 서비스 개발 및 테스트를 위한 가벼운 모킹 서버입니다.

---

## 🚀 시작하기

Mock Server를 시작하려면 아래 환경이 필요합니다:

- **Java Development Kit (JDK)**: 버전 21
- **Kotlin**: 버전 1.9.25
- **Gradle**: 프로젝트 빌드 및 실행용 (권장)

### 리포지토리 클론
```bash
git clone git@github.com:FC-InnerCircle-ICD2/fintech-mock.git
cd mock-server
```

### Package 구조
```text
└── api
    ├── enums                        # 열거형 자료를 정의하는 패키지
    │   └── CardInfoEnum.kt          # 카드 정보 ENUM   
    ├── exception                    # 예외를 정의하는 패키지
    │   ├── CardErrorCode.kt         # 카드 에러 코드 Enum   
    │   └── CardException.kt         # 카드 인증 및 승인에 대한 에러 클래스   
    ├── request                      # 요청 객체를 정의하는 패키지
    │   ├── CardApproveRequest.kt    # 카드 승인 DTO
    │   └── CardValidateRequest.kt   # 카드 인증 DTO
    ├── response                     # 응답 객체를 정의하는 패키지
    │   └── CardMockResponse.kt      # 카드사 응답 DTO
    ├── service                      # 서비스 객체를 정의하는 패키지
    │   └── CardMockResponse.kt      # 카드사 서비스    
    └── CardMockController.kt             # Mocking API 엔드포인트를 처리하는 컨트롤러

```