package br.com.wmwallet.network

import br.com.wmwallet.model.Transaction
import br.com.wmwallet.model.TransactionType
import kotlinx.datetime.LocalDate
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun loadTransaction(): List<Transaction>{
    val mockList = MutableList(5){
        Transaction(
            logo="https://st.depositphotos.com/37050820/58882/v/450/depositphotos_588825948-stock-illustration-spotify-vector-logo-vector-illustration.jpg",
            title = "Spotify",

            transactionType = TransactionType.DEBIT,
            value = 17.00,
            LocalDate(year = 2023, monthNumber = 1, dayOfMonth = 29)
        )
    }
    val data = Json.encodeToString(mockList)

    val deserializado = Json.decodeFromString<List<Transaction>>(data)

    return deserializado
}