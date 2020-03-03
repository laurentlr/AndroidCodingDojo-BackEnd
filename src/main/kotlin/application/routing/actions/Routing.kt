package application.routing.actions

import data.DataBase
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.actions() {

    get("/actions") {
        call.respond(DataBase.actions)
    }

}
