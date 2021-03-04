package com.airwallex.payoutpoc.controller

import com.airwallex.payoutpoc.dto.PayoutConfig
import com.airwallex.payoutpoc.dto.PayoutIntent
import com.airwallex.payoutpoc.dto.PayoutOptions
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

interface RailCapability {
    @PostMapping("payout-options/searches")
    fun getPayoutOptions(payoutOptionSearch: PayoutOptionSearch): PayoutOptions
}

data class PayoutOptionSearch(val payoutIntent: PayoutIntent, val payoutConfig: PayoutConfig)