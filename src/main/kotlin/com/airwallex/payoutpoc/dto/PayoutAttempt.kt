package com.airwallex.payoutpoc.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.OffsetDateTime
import java.util.UUID

/**
 * Payment Creator Domain
 */
typealias Metadata = Map<String, String>
data class PayoutAttempt(
    val id: UUID,
    val payoutIntentId: UUID,
    val payoutMethod: PayoutMethod = PayoutMethod.USER_DEFAULT,
    val bankAccount: BankAccount,
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    val status: PayoutStatus = PayoutStatus.INITED,
    val metadata: Metadata = emptyMap()
)

data class PayoutAttemptWithPayoutIntent(
    val id: UUID,
    val payoutIntent: PayoutIntent,
    val payoutMethod: PayoutMethod = PayoutMethod.USER_DEFAULT,
    val bankAccount: BankAccount,
    val metadata: Metadata = emptyMap()
)

/**
 * Xero case
 */
@Schema(example= """{
  "batchId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "payoutAttempts": [
    {
      "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
      "payoutIntent": {
        "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
        "country": "AU",
        "payoutAmount": {
          "type": "fix_source",
          "sourceAmount": {
            "amount": 1000,
            "currency": "AUD"
          }
        }
      },
      "bankAccount": {
        "type": "bsb",
        "bsbCode": "123",
        "accountNumber": "456"
      },
      "metadata": {
        "additionalProp1": "1"
      }
    }
  ],
  "metadata": {
    "additionalProp2": "2"
  }
}""")
data class BatchPayoutAttemptWithPayoutIntent(
    val batchId: UUID,
    val payoutAttempts: List<PayoutAttemptWithPayoutIntent>,
    val metadata: Metadata = emptyMap(),
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    val createdAt: OffsetDateTime = OffsetDateTime.now(),
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    val status: BatchPayoutStatus = BatchPayoutStatus.INITED
    )

enum class PayoutStatus{
    INITED, AWAITING_DISPATCH, DISPATCHED, REVERSED, CANCELED
}
enum class BatchPayoutStatus{
    INITED, VALIDATED, INVALID, APPROVED, REJECTED, AUTHENTICATED, AUTHENTICATION_FAILED, AWAITING_DISPATCH, DISPATCHED, SETTLED, FUNDING_ERROR, REVERSED, CANCELED
}