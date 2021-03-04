package com.airwallex.payoutpoc.controller

import com.airwallex.payoutpoc.dto.ACHBankAccount
import org.springframework.web.bind.annotation.RestController

@RestController
class BankAccountImpl : BankAccount {
    override fun transform(
        bankAccount: ACHBankAccount,
        targetBankAccountType: String,
    ): com.airwallex.payoutpoc.dto.BankAccount {
        TODO("Not yet implemented")
    }

    override fun validate(bankAccount: ACHBankAccount) {
        TODO("Not yet implemented")
    }
}