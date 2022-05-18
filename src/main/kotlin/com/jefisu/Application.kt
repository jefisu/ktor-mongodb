package com.jefisu

import com.jefisu.di.mainModule
import com.jefisu.plugins.configureMonitoring
import com.jefisu.plugins.configureRouting
import com.jefisu.plugins.configureSerialization
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(Koin) {
        modules(mainModule)
    }

    configureRouting()
    configureSerialization()
    configureMonitoring()
}
