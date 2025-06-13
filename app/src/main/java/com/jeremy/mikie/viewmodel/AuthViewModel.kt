package com.jeremy.mikie.viewmodel




import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeremy.mikie.model.User
import com.jeremy.mikie.repository.UserRepository
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: UserRepository) : ViewModel() {
    var loggedInUser: ((User?) -> Unit)? = null

    fun registerUser(user: User) {
        viewModelScope.launch {
            repository.registerUser(user)
        }
    }

    fun loginUser(email: String, password: String, selectedRole: String) {
        viewModelScope.launch {
            val user = repository.loginUser(email, password)
            loggedInUser?.invoke(user)
        }
    }
}