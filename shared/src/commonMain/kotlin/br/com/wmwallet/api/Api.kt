package br.com.wmwallet.api

import br.com.wmwallet.model.Rick
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Api {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }
    suspend fun getAll(): Rick {
        return httpClient.get("https://rickandmortyapi.com/api/character").body()
    }
    //static instance
    companion object{
        // Lazy only runs instance if it's called Api.instance
        val instance by lazy{Api()}
    }
}
