package com.jeremy.mikie.repository




import com.jeremy.mikie.data.UserDao
import com.jeremy.mikie.model.User

class UserRepository(private val userDao: UserDao) {

    suspend fun registerUser(user: User) {
        userDao.insert(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        val user = userDao.getUserByEmail(email)
        return if (user != null && user.password == password) user else null
    }
}
