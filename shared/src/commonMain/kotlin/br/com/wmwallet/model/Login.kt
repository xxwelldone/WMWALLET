package br.com.wmwallet.model

import kotlinx.serialization.Serializable



class Login(private val email: String, private val password: String) {
    fun validador() = (email == "denisfelippe@gmail.com" && password == "1234")
}