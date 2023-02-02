package br.com.wmwallet.model

import kotlin.test.Test
import kotlin.test.assertTrue

class LoginTest {
    @Test
    fun validarLogin() {
        val login = Login(email="user@kmm.com", senha = "123")
        val isValid = login.validador()

        assertTrue(isValid)
    }
}