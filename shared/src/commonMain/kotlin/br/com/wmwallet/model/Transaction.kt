package br.com.wmwallet.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Transaction(
    val logo: String,
    val title: String,

    val transactionType: TransactionType,
    val value: Double,
    val date: LocalDate
)

enum class TransactionType(val description:String){
    CREDIT("Entrada"),
    DEBIT("Saída")
}
