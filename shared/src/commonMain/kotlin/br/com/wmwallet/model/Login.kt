package br.com.wmwallet.model

class Login(private val email: String, private val senha: String) {
    fun validador() = (email == "user@kmm.com" && senha == "123")
}