package application.routing.fcm

import data.DataBase
import domain.Token
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post

fun Routing.token() {

    get("/tokens") {
        call.respond(DataBase.fcmTokens)
    }

    post("/token") {
        var token: String? = null
        lateinit var responseMessage: String

        try {
            token = call.receive<Token>().token
            responseMessage = "Success"
        } catch (e: Exception) {
            println(e)
            responseMessage = "Error, add header Content-Type:application/json or Token data is wrong !!! $e"
        }

        call.respond(responseMessage)
        token?.let {
            DataBase
                    .fcmTokens
                    .add(it)
        }
    }

}
