package application

import application.routing.actions.actions
import application.routing.fcm.token
import application.routing.user.user
import application.routing.welcome.welcome
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.GsonConverter
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.routing.routing
import java.text.DateFormat

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
        register(ContentType.Application.Json, GsonConverter())
    }

    routing {
        welcome()

        user()
        actions()
        //token()
    }
}


