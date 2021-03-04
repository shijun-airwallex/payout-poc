package com.airwallex.payoutpoc.dto

import java.util.UUID

/**
 * Payment Creator Domain
 */
data class PayoutAttempt(
    val id: UUID,
    val payoutIntentId: UUID,
    val payoutMethod: PayoutMethod,
    val bankAccount: BankAccount,
)
