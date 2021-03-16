package com.airwallex.payoutpoc.dto

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

data class CcyAmount(val amount: BigDecimal, val currency: String)

/**
 * Payment Creator Domain
 */
@Schema(oneOf = [FixSourceFeeByPayer::class, FixTargetFeeByPayer::class], discriminatorProperty="type")
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type")
@JsonSubTypes(value = [
    JsonSubTypes.Type(value = FixSourceFeeByPayer::class, name = "fix_source"),
    JsonSubTypes.Type(value = FixTargetFeeByPayer::class, name = "fix_target")
])
sealed class PayoutAmount(val type: String) {
    @Schema(hidden = true)
    abstract fun getSourceAmount(): CcyAmount
    @Schema(hidden = true)
    abstract fun getTargetAmount(): CcyAmount
    @Schema(hidden = true)
    abstract fun getFeeAmount(): CcyAmount
}

class FixSourceFeeByPayer(private val sourceAmount: CcyAmount) : PayoutAmount("fix_source") {
    @Schema(hidden = false)
    override fun getSourceAmount() = sourceAmount

    override fun getTargetAmount(): CcyAmount {
        return sourceAmount
    }

    override fun getFeeAmount(): CcyAmount {
        return CcyAmount(BigDecimal.ZERO, sourceAmount.currency)
    }

}

class FixTargetFeeByPayer(private val targetAmount: CcyAmount) : PayoutAmount("fix_target") {
    override fun getSourceAmount(): CcyAmount {
        return targetAmount
    }

    @Schema(hidden = false)
    override fun getTargetAmount() = targetAmount

    override fun getFeeAmount(): CcyAmount {
        return CcyAmount(BigDecimal.ZERO, targetAmount.currency)
    }
}

data class FxRate(val sourceCcy: String, val targetCcy: String, val rate: BigDecimal)

sealed class Fee {
    abstract fun getAbsoluteFeeAmount(payoutAmount: CcyAmount): CcyAmount
}

class FixedFee(private val fixedFee: CcyAmount) : Fee() {
    override fun getAbsoluteFeeAmount(payoutAmount: CcyAmount): CcyAmount {
        return fixedFee
    }
}