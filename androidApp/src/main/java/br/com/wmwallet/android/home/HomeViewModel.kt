package br.com.wmwallet.android.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wmwallet.android.repository.TransactionRepository
import br.com.wmwallet.api.Api
import br.com.wmwallet.model.Login
import br.com.wmwallet.model.Profile
import br.com.wmwallet.model.Transaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(val repo: TransactionRepository = TransactionRepository.instance) :
    ViewModel() {

    private val _transaction = MutableStateFlow<List<Transaction>>(emptyList())
    val transaction: StateFlow<List<Transaction>> = _transaction

    private val _profile = MutableStateFlow<Profile?>(null)
    val profile: StateFlow<Profile?> = _profile

    init {}

    fun login() = viewModelScope.launch {
        Api.instance.login(Login(email = "denisfelippe@gmail.com", password = "1234"))
    }.invokeOnCompletion {
        getTransactions()
        getProfiles()
    }


    fun getTransactions() = viewModelScope.launch {
        repo.getTrans().collectLatest {
            _transaction.value = it
        }

    }

    fun getProfiles() = viewModelScope.launch {
        repo.getProfile().collectLatest {
            _profile.value = it
        }
    }
}