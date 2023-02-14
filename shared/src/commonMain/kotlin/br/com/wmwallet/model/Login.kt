package br.com.wmwallet.model

import kotlinx.serialization.Serializable



class Login(private val email: String, private val password: String) {
    fun validador() = (email == "user@kmm.com" && password == "123")
}