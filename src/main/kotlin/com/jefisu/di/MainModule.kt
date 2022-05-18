package com.jefisu.di

import com.jefisu.data.MongoUserDataSource
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        val mongoPw = System.getenv("MONGO_PW")
        KMongo.createClient(
            connectionString = "mongodb+srv://jefisu:$mongoPw@ktor-user.bmj12.mongodb.net/?retryWrites=true&w=majority"
        )
            .getDatabase("users")
            .coroutine
    }
    single {
        MongoUserDataSource(get())
    }
}