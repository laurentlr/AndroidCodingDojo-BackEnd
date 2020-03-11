package application.routing.actions

import application.routing.fcm.Fcm
import data.DataBase
import domain.Action
import domain.Response
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post

fun Routing.actions() {

    get("/actions") {
        call.respond(DataBase.actions)
    }

    post("/action") {
        var action: Action? = null
        lateinit var message: String

        try {
            action = call.receive()
            message = "Success"
        } catch (e: Exception) {
            message = "Error, add header Content-Type:application/json or Action data is wrong !!! $e"
        }

        call.respond(Response(message))

        action?.let {
            DataBase.actions.add(it)
            Fcm.onActionAdded(it)
        }
    }

}
