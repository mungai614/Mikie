package com.jeremy.mikie.repository




import com.jeremy.mikie.data.UserDao
import com.jeremy.mikie.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}