package com.airwallex.payoutpoc.controller

import com.airwallex.payoutpoc.dto.BatchPayoutAttemptWithPayoutIntent
import com.airwallex.payoutpoc.dto.PayoutAttempt
import com.airwallex.payoutpoc.dto.PayoutCreated
import com.airwallex.payoutpoc.dto.PayoutIntent
import com.airwallex.payoutpoc.dto.PayoutOption
import com.airwallex.payoutpoc.dto.PayoutOptions
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
class PayoutCreatorImpl : PayoutCreator {
    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun getPayoutOptions(payoutIntent: PayoutIntent): PayoutOptions {
        logger.info("$payoutIntent")
        return PayoutOptions(emptyList())
    }

    override fun getPayoutOption(payoutIntent: PayoutIntent): Optional<PayoutOption> {
        TODO("Not yet implemented")
    }

    override fun createPayout(payoutAttempt: PayoutAttempt): PayoutAttempt {
        return payoutAttempt
    }

    override fun createBatchPayout(batchPayoutAttemptWithPayoutIntent: BatchPayoutAttemptWithPayoutIntent): BatchPayoutAttemptWithPayoutIntent {
        return batchPayoutAttemptWithPayoutIntent
    }
}