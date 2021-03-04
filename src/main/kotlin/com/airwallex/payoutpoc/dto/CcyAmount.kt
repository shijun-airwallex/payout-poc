package com.airwallex.payoutpoc.dto

import java.math.BigDecimal

data class CcyAmount(val amount: BigDecimal, val currency: String)

/**
 * Payment Creator Domain
 */
sealed class PayoutAmount {
    abstract fun getSourceAmount(): CcyAmount
    abstract fun getTargetAmount(): CcyAmount
    abstract fun getFeeAmount(): CcyAmount
}

class FixSourceFeeByPayer(private val sourceAmount: CcyAmount, val fee: Fee, val fxRates: List<FxRate>) : PayoutAmount() {
    override fun getSourceAmount() = sourceAmount

    override fun getTargetAmount(): CcyAmount {
        TODO("Not yet implemented")
    }

    override fun getFeeAmount(): CcyAmount {
        TODO("Not yet implemented")
    }

}

class FixTargetFeeByPayer(private val targetAmount: CcyAmount, val fxRates: List<FxRate>) : PayoutAmount() {
    override fun getSourceAmount(): CcyAmount {
        TODO("Not yet implemented")
    }

    override fun getTargetAmount() = targetAmount

    override fun getFeeAmount(): CcyAmount {
        TODO("Not yet implemented")
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