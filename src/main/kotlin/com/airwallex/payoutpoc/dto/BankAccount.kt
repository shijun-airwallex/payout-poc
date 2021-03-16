package com.airwallex.payoutpoc.dto

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse

/**
 * Bank Account Domain
 */
@Schema(oneOf = [ACHBankAccount::class, FedWireBankAccount::class, BsbBankAccount::class],
    discriminatorProperty = "type")
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type")
@JsonSubTypes(value = [
    JsonSubTypes.Type(value = ACHBankAccount::class, name = "ach"),
    JsonSubTypes.Type(value = FedWireBankAccount::class, name = "fed_wire"),
    JsonSubTypes.Type(value = BsbBankAccount::class, name = "bsb")
])
sealed class BankAccount(val type: String)
data class ACHBankAccount(
    @Schema(maxLength = 10)
    val achRoutingNumber: String,
    @Schema(allowableValues = ["3", "5"])
    val accountNumber: String,
) : BankAccount("ach") {
    fun toFedWireBankAccount(): FedWireBankAccount {
        //mock
        return FedWireBankAccount(achRoutingNumber, accountNumber)
    }
}

data class FedWireBankAccount(val fpsRoutingCode: String, val accountNumber: String) : BankAccount("fed_wire")
data class BsbBankAccount(val bsbCode: String, val accountNumber: String) : BankAccount("bsb")