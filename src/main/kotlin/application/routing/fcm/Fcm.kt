package application.routing.fcm

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.MulticastMessage
import com.google.firebase.messaging.Notification
import com.google.gson.Gson
import data.DataBase
import domain.Action


class Fcm {

    companion object {
        fun onActionAdded(action: Action) {
            println("lolo")
            val message = MulticastMessage.builder()
                    .setNotification(
                            Notification
                                    .builder()
                                    .setTitle("New action Dojo")
                                    .setBody(action.description)
                                    .setImage("https://image.shutterstock.com/image-vector/dojo-logo-red-color-260nw-1420658216.jpg")
                                    .build()
                    )
                    .putData("action", Gson().toJson(action))
                    .addAllTokens(DataBase.fcmTokens)
                    .build()
            try {
                val response = FirebaseMessaging.getInstance().sendMulticast(message)
                println("lolo" + response.successCount.toString() + " messages were sent successfully")
                println(response.responses)
            } catch (e: Exception) {
                println("lolo: $e")
            }
        }
    }
}