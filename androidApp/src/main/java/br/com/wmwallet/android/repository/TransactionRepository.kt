package br.com.wmwallet.android.repository

import br.com.wmwallet.api.Api

import br.com.wmwallet.model.Transaction
import kotlinx.coroutines.flow.flow

class TransactionRepository(private val api: Api = Api.instance) {

    suspend fun getTrans() = flow<List<Transaction>> {
        val chamada = api.getAll().transaction
        emit(chamada)
    }

    suspend fun getProfile() = flow {
        emit(api.profile())
    }

    companion object {
        val instance by lazy { TransactionRepository() }
    }
}
