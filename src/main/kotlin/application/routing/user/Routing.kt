package application.routing.user

import data.DataBase
import domain.Response
import domain.User
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.delete
import io.ktor.routing.get
import io.ktor.routing.post

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

    post("/user") {
        var user: User? = null
        lateinit var message: String

        try {
            val receivedUser = call.receive<User>()
            user = User(
                    name = receivedUser.name,
                    avatar = receivedUser.avatar
            )
            message = "Success"
        } catch (e: Exception) {
            message = "Error, add header Content-Type:application/json or User data is wrong !!! $e"
        }

        call.respond(Response(message))

        user?.let { DataBase.users.add(it) }
    }

    delete("/user/{id?}") {
        call.parameters["id"]?.let { userId ->
            DataBase.users.removeIf { it.id == userId }
        }
        call.respond(Response("Done"))
    }

}
