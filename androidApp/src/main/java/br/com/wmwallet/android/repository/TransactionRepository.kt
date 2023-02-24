package br.com.wmwallet.android.repository

import br.com.wmwallet.api.Api

import br.com.wmwallet.model.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TransactionRepository(private val api: Api = Api.instance) {

    suspend fun getTrans() = flow<List<Transaction>> {
        val chamada = api.getAll().transaction
        emit(chamada)
    }.flowOn(Dispatchers.Default)

    suspend fun getProfile() = flow {
        emit(api.profile())
    }.flowOn(Dispatchers.Default)

    companion object {
        val instance by lazy { TransactionRepository() }
    }
}
