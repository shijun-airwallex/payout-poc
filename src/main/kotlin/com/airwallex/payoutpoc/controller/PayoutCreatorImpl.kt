package com.airwallex.payoutpoc.controller

import com.airwallex.payoutpoc.dto.PayoutAttempt
import com.airwallex.payoutpoc.dto.PayoutCreated
import com.airwallex.payoutpoc.dto.PayoutIntent
import com.airwallex.payoutpoc.dto.PayoutOption
import com.airwallex.payoutpoc.dto.PayoutOptions
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
class PayoutCreatorImpl : PayoutCreator {
    override fun getPayoutOptions(payoutIntent: PayoutIntent): PayoutOptions {
        TODO("Not yet implemented")
    }

    override fun getPayoutOption(payoutIntent: PayoutIntent): Optional<PayoutOption> {
        TODO("Not yet implemented")
    }

    override fun createPayout(payoutAttempt: PayoutAttempt): PayoutCreated {
        TODO("Not yet implemented")
    }
}