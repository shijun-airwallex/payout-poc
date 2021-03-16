package com.airwallex.payoutpoc.dto

/**
 * Rail Capability Domain
 */
data class PayoutOption(
    val payoutMethod: PayoutMethod,
    val limit: IntRange,
    val fee: Fee,
)

data class PayoutOptions (
    val options: List<PayoutOptions>
)

enum class PayoutMethod(supportBankAccountType: List<String>) {
    USER_DEFAULT(listOf()), SLOW(listOf("ACHBankAccount")), FAST(listOf("FedWireBankAccount"));
}

