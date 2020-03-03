package application.routing.user

import data.DataBase
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.user() {

    get("/users/{name?}") {
        call.respond(
                call.parameters["name"]?.let {
                    DataBase.users.filter { user -> user.name.toLowerCase() == it.toLowerCase() }
                }
                        ?: DataBase.users
        )
    }

    get("/users/{id?}") {
        call.respond(
                call.parameters["id"]?.let {
                    DataBase.users.filter { user -> user.id.toLowerCase() == it.toLowerCase() }
                }
                        ?: DataBase.users
        )
    }

}
