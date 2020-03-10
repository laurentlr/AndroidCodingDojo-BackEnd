package application.routing.fcm

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.MulticastMessage
import com.google.gson.Gson
import data.DataBase
import domain.Action


class Fcm {

    companion object {
        fun onActionAdded(action: Action) {
            val message = MulticastMessage.builder()
                    .putData("action", Gson().toJson(action))
                    .addAllTokens(DataBase.fcmTokens)
                    .build()
            val response = FirebaseMessaging.getInstance().sendMulticast(message)
            println(response.successCount.toString() + " messages were sent successfully")
        }
    }
}