package com.airwallex.payoutpoc.controller

import com.airwallex.payoutpoc.dto.PayoutOptions
import org.springframework.web.bind.annotation.RestController

@RestController
class RailCapabilityImpl : RailCapability {
    override fun getPayoutOptions(payoutOptionSearch: PayoutOptionSearch): PayoutOptions {
        TODO("Not yet implemented")
    }
}