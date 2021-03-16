package com.airwallex.payoutpoc.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.util.UUID

/**
 * Payment Creator Domain
 */
data class PayoutIntent(
    val id: UUID,
    val country: String,
    val payoutAmount: PayoutAmount,
    val preference: String? = "LOWEST_FEE",
)
