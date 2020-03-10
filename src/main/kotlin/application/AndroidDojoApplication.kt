package application

import application.routing.actions.actions
import application.routing.fcm.token
import application.routing.user.user
import application.routing.welcome.welcome
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.GsonConverter
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.routing.routing
import java.io.FileInputStream
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

    initFireBase()

    routing {
        welcome()

        user()
        actions()
        //token()
    }
}

fun initFireBase() {
    val serviceAccount = FileInputStream("path/to/serviceAccountKey.json")

    val options = FirebaseOptions
            .Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://androidcodingdojo.firebaseio.com")
            .build()

    FirebaseApp.initializeApp(options)
}


