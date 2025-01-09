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
    ├── request              # 요청 객체를 정의하는 패키지
    │   ├── CardUsageRequest.kt     # 카드 사용 요청 DTO
    │   ├── PaymentRequest.kt       # 결제 요청 DTO
    │   └── TransactionRequest.kt   # 트랜잭션 요청 DTO
    ├── response             # 응답 객체를 정의하는 패키지
    │   ├── CardUsageResponse.kt    # 카드 사용 응답 DTO
    │   ├── PaymentResponse.kt      # 결제 응답 DTO
    │   └── TransactionResponse.kt  # 트랜잭션 응답 DTO
    └── ApiController.kt     # Mocking API 엔드포인트를 처리하는 컨트롤러

```