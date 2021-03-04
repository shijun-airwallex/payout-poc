package com.airwallex.payoutpoc.controller

import com.airwallex.payoutpoc.dto.ACHBankAccount
import com.airwallex.payoutpoc.dto.BankAccount
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("bankaccounts/")
interface BankAccount {

    @GetMapping(params = ["from=ACH"])
    fun transform(@ModelAttribute bankAccount: ACHBankAccount, @RequestParam("to") targetBankAccountType: String): BankAccount
    @GetMapping("validation", params = ["from=ACH"])
    fun validate(@ModelAttribute bankAccount: ACHBankAccount)
}