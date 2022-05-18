package com.jefisu.routes

import com.jefisu.data.UserDataSource
import com.jefisu.data.request.User
import com.jefisu.data.response.SimpleResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.insertUser(
    dataSource: UserDataSource
) {
    post("api/user") {
        val user = call.receiveOrNull<User>() ?: kotlin.run {
            call.respond(HttpStatusCode.BadRequest, "Filling the fields is invalid")
            return@post
        }

        val result = dataSource.insertUser(user)
        if (!result) {
            call.respond(HttpStatusCode.BadRequest, "Error when inserting")
            return@post
        }
        call.respond(HttpStatusCode.OK, "User successfully inserted")
    }
}

fun Route.getUser(
    dataSource: UserDataSource
) {
    get("api/user/{value}") {
        val request = call.parameters["value"] ?: kotlin.run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val result = dataSource.getUser(request)
        if (result == null) {
            SimpleResponse<User>(null, "User not found")
                .also {
                    call.respond(HttpStatusCode.NotFound, it)
                }
            return@get
        }
        call.respond(HttpStatusCode.OK, SimpleResponse(result))
    }
}