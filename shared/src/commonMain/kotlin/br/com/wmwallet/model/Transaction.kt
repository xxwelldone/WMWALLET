package br.com.wmwallet.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Transaction(
    val id:Int,
    val logo: String,
    val title: String,
    val background:String,
    @SerialName("type")
    val transactionType: TransactionType,
    val value: Double,
    @SerialName("createdAt")
    val date: LocalDate
)

@Serializable
data class TransactionResponse(val transaction: List<Transaction>)
enum class TransactionType(val description: String) {
    CREDIT("Entrada"),
    DEBIT("Saída")
}
