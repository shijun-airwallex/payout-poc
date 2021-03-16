package com.airwallex.payoutpoc.controller

import com.airwallex.payoutpoc.dto.BatchPayoutAttemptWithPayoutIntent
import com.airwallex.payoutpoc.dto.PayoutAttempt
import com.airwallex.payoutpoc.dto.PayoutCreated
import com.airwallex.payoutpoc.dto.PayoutIntent
import com.airwallex.payoutpoc.dto.PayoutOption
import com.airwallex.payoutpoc.dto.PayoutOptions
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional
import java.util.UUID

@RequestMapping("payouts/")
interface PayoutCreator {
    @PostMapping("options")
    fun getPayoutOptions(@RequestBody payoutIntent: PayoutIntent): PayoutOptions
    @PostMapping("option")
    fun getPayoutOption(@RequestBody payoutIntent: PayoutIntent): Optional<PayoutOption>
    @PostMapping("attempts")
    fun createPayout(@RequestBody payoutAttempt: PayoutAttempt): PayoutAttempt
    @PostMapping("batch-attempts")
    fun createBatchPayout(@RequestBody batchPayoutAttemptWithPayoutIntent: BatchPayoutAttemptWithPayoutIntent): BatchPayoutAttemptWithPayoutIntent

}