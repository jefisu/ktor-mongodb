package com.jefisu.data

import com.jefisu.data.request.User

interface UserDataSource {
    suspend fun insertUser(user: User): Boolean

    suspend fun getUser(value: String): User?
}