package com.airwallex.payoutpoc.dto

import java.util.UUID

data class PayoutConfig(
    val payerId: UUID,
    val payerEntityType: String,
    val industry: Industry,
    val routingSettings: List<RoutingSetting>
)

class Industry
class RoutingSetting