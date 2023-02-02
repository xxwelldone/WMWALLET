package br.com.wmwallet

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform