package br.com.wmwallet.api

import br.com.wmwallet.model.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlin.native.concurrent.ThreadLocal

class Api {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                },
            )
        }

        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer $token")
        }
    }

    suspend fun getAll(): TransactionResponse {
        return httpClient.get("$DEFAULT_URL/transaction").body()
    }

    suspend fun login(login: Login): ProfileToken {
        return httpClient.post("$DEFAULT_URL/login") {
            setBody(login)
        }.body()
    }

    suspend fun profile(): Profile = httpClient.get("$DEFAULT_URL/user/profile").body()

    @ThreadLocal
    companion object {
        val instance by lazy { Api() }
        var token = ""
        const val DEFAULT_URL = "https://dh-wallet-2.herokuapp.com"
    }
}
