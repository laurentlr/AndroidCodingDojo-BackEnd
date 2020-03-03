package application.routing.welcome

import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.routing.Routing
import io.ktor.routing.get
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.h2
import kotlinx.html.head
import kotlinx.html.p
import kotlinx.html.title

fun Routing.welcome() {

    get("") {
        call.respondHtml {
            head {
                title { +"Welcome to this Android Coding Dojo" }
            }
            body {
                div {
                    h1 { +"Welcome to this Android Coding Dojo" }

                    h2 { +"Part I" }
                    p { +"Simple list" }

                    h2 { +"Part II" }
                    p { +"Simple list connected to back end" }

                    h2 { +"Part III" }
                    p { +"Amazing stuff" }

                }

                div { +"<i>By Laurent Russier & Sylvain Choquet</i>" }
            }
        }
    }

}
