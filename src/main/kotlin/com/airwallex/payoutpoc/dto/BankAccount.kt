package com.airwallex.payoutpoc.dto

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse

/**
 * Bank Account Domain
 */
sealed class BankAccount
data class ACHBankAccount(
    @Schema(maxLength = 10)
    val achRoutingNumber: String,
    @Schema(allowableValues = ["3", "5"])
    val accountNumber: String,
) : BankAccount() {
    fun toFedWireBankAccount(): FedWireBankAccount {
        //mock
        return FedWireBankAccount(achRoutingNumber, accountNumber)
    }
}

data class FedWireBankAccount(val fpsRoutingCode: String, val accountNumber: String) : BankAccount()