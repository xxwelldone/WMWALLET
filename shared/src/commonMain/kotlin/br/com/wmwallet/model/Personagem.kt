package br.com.wmwallet.model

@kotlinx.serialization.Serializable
class Rick(val results: List<Personagem>) {}

@kotlinx.serialization.Serializable
class Personagem(val name: String, val image: String) {
}