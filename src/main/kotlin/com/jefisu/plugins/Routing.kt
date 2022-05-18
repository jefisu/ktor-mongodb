package com.jefisu.plugins

import com.jefisu.data.MongoUserDataSource
import com.jefisu.routes.getUser
import com.jefisu.routes.insertUser
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val dataSource by inject<MongoUserDataSource>()

    routing {
        insertUser(dataSource)
        getUser(dataSource)
    }
}
