package com.jefisu.data

import com.jefisu.data.request.User
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class MongoUserDataSource(
    db: CoroutineDatabase
) : UserDataSource {

    private val users = db.getCollection<User>()

    override suspend fun insertUser(user: User): Boolean {
        return users.insertOne(user).wasAcknowledged()
    }

    override suspend fun getUser(value: String): User? {
        users.findOneById(value)?.let {
            return it
        }
        return users.findOne(User::nickname eq value)
    }
}